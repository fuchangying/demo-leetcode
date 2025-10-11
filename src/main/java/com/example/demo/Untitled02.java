package com.example.demo;

public class Untitled02 {
    
    public static void main(String[] args) {
        // 示例1：匿名内部类访问外部局部变量
        int externalVar = 10;
        System.out.println("外部变量初始值: " + externalVar);
        
        // 创建匿名内部类实现Runnable接口
        Runnable task = new Runnable() {
            @Override
            public void run() {
                // 匿名内部类可以访问外部局部变量，但必须是final或effectively final
                System.out.println("匿名内部类中访问外部变量: " + externalVar);
                
                // 注意：不能直接修改外部局部变量，因为它是effectively final的
                // externalVar = 20; // 这行代码会编译错误
            }
        };
        
        // 执行匿名内部类
        task.run();
        
        // 示例2：使用数组来实现在匿名内部类中修改外部变量
        int[] mutableVar = {10};
        System.out.println("\n使用数组方式 - 外部变量初始值: " + mutableVar[0]);
        
        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                // 可以修改数组中的值
                mutableVar[0] = 20;
                System.out.println("匿名内部类中修改后的值: " + mutableVar[0]);
            }
        };
        
        task2.run();
        System.out.println("外部访问修改后的值: " + mutableVar[0]);
        
        // 示例3：使用包装类
        IntegerWrapper wrapper = new IntegerWrapper(30);
        System.out.println("\n使用包装类方式 - 外部变量初始值: " + wrapper.getValue());
        
        Runnable task3 = new Runnable() {
            @Override
            public void run() {
                // 可以修改包装类对象的值
                wrapper.setValue(40);
                System.out.println("匿名内部类中修改后的值: " + wrapper.getValue());
            }
        };
        
        task3.run();
        System.out.println("外部访问修改后的值: " + wrapper.getValue());
        
        // 示例4：匿名内部类实现其他接口
        Calculator calculator = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return a + b;
            }
        };
        
        int result = calculator.calculate(5, 3);
        System.out.println("\n匿名内部类计算结果: " + result);
    }
    
    // 自定义包装类
    static class IntegerWrapper {
        private int value;
        
        public IntegerWrapper(int value) {
            this.value = value;
        }
        
        public int getValue() {
            return value;
        }
        
        public void setValue(int value) {
            this.value = value;
        }
    }
    
    // 自定义接口
    interface Calculator {
        int calculate(int a, int b);
    }
}
