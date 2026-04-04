package com.multithreading;

public class MyThread extends Thread{

//    public MyThread(String name){
//        super(name);
//    }
//
//    @Override
//    public void run() {
//      for (int i = 0; i<5; i++){
//          String a = "";
//          for (int j = 0; j<10000; j++){
//              a += "a";
//          }
//          System.out.println(Thread.currentThread().getName() + " - Priority " + Thread.currentThread().getPriority() + " - Count "+i);
//          try{
//              Thread.sleep(10);
//          }catch (Exception e){
//            e.printStackTrace();
//          }
//      }
//    }


//    public static void main(String[] args) throws InterruptedException {
//
//        MyThread l = new MyThread("Low Priority Thread");
//        MyThread m = new MyThread("Medium Priority Thread");
//        MyThread h = new MyThread("High Priority Thread");
//        l.setPriority(Thread.MIN_PRIORITY);
//        h.setPriority(Thread.NORM_PRIORITY);
//        h.setPriority(Thread.MAX_PRIORITY);
//        l.start();
//        m.start();
//        h.start();
//    }

    private Counter counter;

    public MyThread(Counter counter){
        this.counter = counter;
    }


    @Override
    public void run() {
        for (int i = 0;  i<1000; i++){
            counter.increment();
        }
    }
}
