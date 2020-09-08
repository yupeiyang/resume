package uninterruptibility;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ypy
 *
 * 演示Lock的不可中断特性
 * 不可中断是指，当一个线程获得锁后，另一个线程一直处于阻塞或等待状态，
 * 前一个线程不释放锁，后一个线程会一直阻塞或等待，不可被中断。
 */
public class Demo2 {
    //定义Lock对象
    private static Lock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        test();
    }

    //演示Lock的不可中断性,Lock的lock方法是不可中断的
    public static void test() throws InterruptedException{
        Runnable runnable = () -> {
            String name = Thread.currentThread().getName();
            try{
                lock.lock();
                System.out.println(name+"获取锁");
            } finally {
                lock.unlock();
                System.out.println(name+"释放锁");
            }
        };

        Thread thread0 = new Thread(runnable);
        thread0.start();
        Thread thread1 = new Thread(runnable);
        thread1.start();

        System.out.println("thread-0线程的状态"+thread0.getState());
        System.out.println("thread-1线程的状态"+thread1.getState());

        System.out.println("对thread-1线程尝试进行中断");
        //由于lock的不可中断性，使得thread1线程并不能被中断
        thread1.interrupt();
        System.out.println("对thread-1线程尝试进行中断后");
        //System.out.println("thread-1线程的状态"+thread1.getState());

        System.out.println("thread-0线程的状态"+thread0.getState());
        System.out.println("thread-1线程的状态"+thread1.getState());
    }
}
