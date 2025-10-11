package com.example.demo;

import java.util.concurrent.atomic.LongAdder;

public class Untitled01 {
    public static void main(String[] args) {
        // LongAdder 在高并发场景下会比 AtomicInteger 和 AtomicLong 的性能更好
        // 代价就是会消耗更多的内存空间（空间换时间）
        LongAdder sum = new LongAdder();
        sum.increment();

        String str = "new bee";
        UntitledN untitledN = new UntitledN() {
            @Override
            public void demoString(String a) {
                System.out.println(a + str);

            }
        };
        untitledN.demoString("hanandong");
    }

    public interface UntitledN {
        public void demoString(String a);
    }
}
