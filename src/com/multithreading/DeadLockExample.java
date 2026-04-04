package com.multithreading;

class Pen{
    public synchronized void writeWithPenAndPaper(Paper paper){
        System.out.println(Thread.currentThread().getName() + " is using pen " + this + "and trying to acquire paper");
        paper.finishWriting();
    }

    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName() + " finish using pen " + this);
    }
}


class Paper{
    public synchronized void writeWithPaperAndPen(Pen pen){
        System.out.println(Thread.currentThread().getName() + " is using paper " + this + "and trying to acquire pen");
        pen.finishWriting();
    }

    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName() + " finish using paper " + this);
    }
}

class Task1 implements Runnable{

    private Pen pen;

    private Paper paper;

    public Task1(Paper paper,Pen pen){
        this.paper = paper;
        this.pen = pen;
    }

    @Override
    public void run() {
    pen.writeWithPenAndPaper(paper);
    }
}

class Task2 implements Runnable{

    private Pen pen;

    private Paper paper;

    public Task2(Paper paper,Pen pen){
        this.paper = paper;
        this.pen = pen;
    }

    @Override
    public void run() {
        synchronized (pen){
            paper.writeWithPaperAndPen(pen);
        }
    }
}

public class DeadLockExample {

    public static void main(String[] args) {
        Pen pen = new Pen();
        Paper paper = new Paper();

        Thread thread1 = new Thread(new Task1(paper,pen),"Thread-1");
        Thread thread2  = new Thread(new Task2(paper,pen),"Thread-2");

        thread1.start();
        thread2.start();
    }





}
