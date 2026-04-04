package com.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private int balance = 100;

    private final Lock lock = new ReentrantLock();

    public void withDraw(int amount){
        System.out.println(Thread.currentThread().getName() + " Attempting to withdraw " + amount);
//        if (balance >= amount){
//            System.out.println(Thread.currentThread().getName() + " Proceeding with withdrawal");
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            balance -= amount;
//            System.out.println(Thread.currentThread().getName() + " Completed Withdrawal. Balance :  " + balance);
//        }else {
//            System.out.println(Thread.currentThread().getName() + " Insufficient Balance");
//        }


        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)){
             if (balance >= amount){
                 try {
                     System.out.println(Thread.currentThread().getName() + " Proceeding with withdrawal");
                     Thread.sleep(3000);
                     balance -= amount;
                     System.out.println(Thread.currentThread().getName() + " Completed Withdrawal. Balance :  " + balance);
                 }catch (Exception e){
                     Thread.currentThread().interrupt();
                 }finally {
                     lock.unlock();
                 }
             }else {
                 System.out.println(Thread.currentThread().getName() + " Insufficient Balance");
             }
            }else {
                System.out.println(Thread.currentThread().getName() + " Could not acquire the the lock try again later");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
