import com.multithreading.BankAccount;
import com.multithreading.Counter;
import com.multithreading.MyThread;
import com.multithreading.World;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        World world = new World();
//        world.start();
//
//        for (; ; ) {
//            System.out.println(Thread.currentThread().getName());
//        }

//        Counter counter = new Counter();
//        MyThread t1 = new MyThread(counter);
//        MyThread t2 = new MyThread(counter);
//        t1.start();
//        t2.start();
//        try{
//            t1.join();
//            t2.join();
//        }catch (Exception e){
//
//        }
//        System.out.println(counter.getCount());
        BankAccount bankAccount = new BankAccount();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                bankAccount.withDraw(50);
            }
        };

        Thread t1 = new Thread(task,"Thread-1");
        Thread t2 = new Thread(task,"Thread-2");
        t1.start();
        t2.start();

    }
}