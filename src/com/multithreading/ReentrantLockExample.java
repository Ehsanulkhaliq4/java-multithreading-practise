package com.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    private final Lock LOCK = new ReentrantLock();

    public void outerMethod(){
        try {
            LOCK.lock();
            System.out.println("Outer Method Calling");
            innerMethod();
        }finally {
            LOCK.unlock();
        }
    }

    public void innerMethod(){
        try {
            LOCK.lock();
            System.out.println("Inner Method Calling");
        }finally {
            LOCK.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockExample lockExample = new ReentrantLockExample();
        lockExample.outerMethod();
    }
}
