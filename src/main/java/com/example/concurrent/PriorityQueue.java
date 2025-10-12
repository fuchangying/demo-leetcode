package com.example.concurrent;

import java.util.concurrent.*;

/**
 * 使用PriorityBlockingQueue实现线程池任务优先级调度
 * 通过自定义比较方法，可以控制任务的执行顺序
 */
public class PriorityQueue {

    /**
     * 自定义优先级任务类
     * 实现Runnable接口用于执行任务
     * 实现Comparable接口用于优先级比较
     */
    static class PriorityTask implements Runnable, Comparable<PriorityTask> {
        private final int priority; // 优先级，数值越小优先级越高
        private final String taskName;
        private final long createTime; // 创建时间，用于相同优先级时按FIFO排序

        public PriorityTask(int priority, String taskName) {
            this.priority = priority;
            this.taskName = taskName;
            this.createTime = System.nanoTime();
        }

        @Override
        public void run() {
            try {
                System.out.println(String.format("[线程: %s] 开始执行任务: %s (优先级: %d)",
                        Thread.currentThread().getName(), taskName, priority));
                // 模拟任务执行
                Thread.sleep(1000);
                System.out.println(String.format("[线程: %s] 完成任务: %s",
                        Thread.currentThread().getName(), taskName));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("任务被中断: " + taskName);
            }
        }

        @Override
        public int compareTo(PriorityTask other) {
            // 首先按优先级比较，数值越小优先级越高
            int result = Integer.compare(this.priority, other.priority);
            if (result == 0) {
                // 优先级相同时，按创建时间排序（先创建的先执行，FIFO）
                result = Long.compare(this.createTime, other.createTime);
            }
            return result;
        }

        public int getPriority() {
            return priority;
        }

        public String getTaskName() {
            return taskName;
        }
    }

    /**
     * 创建使用PriorityBlockingQueue的线程池
     */
    public static ThreadPoolExecutor createPriorityThreadPool(int corePoolSize, int maximumPoolSize) {
        return new ThreadPoolExecutor(
                corePoolSize,                           // 核心线程数
                maximumPoolSize,                        // 最大线程数
                60L,                                    // 空闲线程存活时间
                TimeUnit.SECONDS,                       // 时间单位
                new PriorityBlockingQueue<>(),         // 使用优先级阻塞队列
                Executors.defaultThreadFactory(),       // 默认线程工厂
                new ThreadPoolExecutor.AbortPolicy()    // 拒绝策略
        );
    }

    /**
     * 演示示例
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== 线程池优先级队列示例 ===\n");

        // 创建包含优先级队列的线程池（2个核心线程）
        ThreadPoolExecutor executor = createPriorityThreadPool(2, 4);

        // 提交不同优先级的任务
        // 优先级: 1(最高) < 2 < 3 < 4 < 5(最低)
        System.out.println("提交任务中...\n");

        executor.execute(new PriorityTask(3, "任务A - 中等优先级"));
        executor.execute(new PriorityTask(1, "任务B - 最高优先级"));
        executor.execute(new PriorityTask(5, "任务C - 最低优先级"));
        executor.execute(new PriorityTask(2, "任务D - 高优先级"));
        executor.execute(new PriorityTask(1, "任务E - 最高优先级"));
        executor.execute(new PriorityTask(4, "任务F - 低优先级"));
        executor.execute(new PriorityTask(2, "任务G - 高优先级"));
        executor.execute(new PriorityTask(3, "任务H - 中等优先级"));

        // 等待一会儿，让部分任务进入队列
        Thread.sleep(500);

        System.out.println("\n--- 预期执行顺序（相同优先级按提交顺序）：");
        System.out.println("1. 任务B (优先级1) 和 任务E (优先级1) 先执行");
        System.out.println("2. 任务D (优先级2) 和 任务G (优先级2)");
        System.out.println("3. 任务A (优先级3) 和 任务H (优先级3)");
        System.out.println("4. 任务F (优先级4)");
        System.out.println("5. 任务C (优先级5)\n");

        // 优雅关闭线程池
        executor.shutdown();
        executor.awaitTermination(30, TimeUnit.SECONDS);

        System.out.println("\n=== 所有任务执行完成 ===");

        // 示例2: 动态优先级调整场景
        demonstrateCustomComparator();
    }

    /**
     * 演示自定义比较器的场景
     */
    public static void demonstrateCustomComparator() throws InterruptedException {
        System.out.println("\n\n=== 自定义比较器示例（按任务名称字母顺序执行） ===\n");

        // 使用自定义比较器的优先级队列
        PriorityBlockingQueue<Runnable> customQueue = new PriorityBlockingQueue<>(10,
                (r1, r2) -> {
                    if (r1 instanceof PriorityTask && r2 instanceof PriorityTask) {
                        PriorityTask t1 = (PriorityTask) r1;
                        PriorityTask t2 = (PriorityTask) r2;
                        // 按任务名称字母顺序排序
                        return t1.getTaskName().compareTo(t2.getTaskName());
                    }
                    return 0;
                });

        ThreadPoolExecutor customExecutor = new ThreadPoolExecutor(
                2, 4, 60L, TimeUnit.SECONDS,
                customQueue,
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        System.out.println("提交任务（按名称字母顺序执行）...\n");

        customExecutor.execute(new PriorityTask(1, "任务Z"));
        customExecutor.execute(new PriorityTask(1, "任务A"));
        customExecutor.execute(new PriorityTask(1, "任务M"));
        customExecutor.execute(new PriorityTask(1, "任务C"));
        customExecutor.execute(new PriorityTask(1, "任务E"));

        customExecutor.shutdown();
        customExecutor.awaitTermination(30, TimeUnit.SECONDS);

        System.out.println("\n=== 自定义比较器示例完成 ===");
    }
}
