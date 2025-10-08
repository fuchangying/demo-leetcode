package com.example.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class Singleton {

    public static volatile Singleton uniqueInstance;

    public static Singleton getUniqueInstance() {
        if (uniqueInstance != null) {
            return uniqueInstance;
        }
        synchronized (Singleton.class) {
            if (uniqueInstance == null) {
                uniqueInstance = new Singleton();
            }
        }
        return uniqueInstance;
    }

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.unlock();
    }
}
