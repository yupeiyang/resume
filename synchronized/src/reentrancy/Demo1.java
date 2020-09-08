package reentrancy;

/**
 * synchronized的可重入性展示：synchronized 是可重入锁
 *
 * 重入锁实现可重入性原理或机制是：每一个锁关联一个线程持有者和计数器，当计数器为 0 时表示该锁没有被任何线程持有，
 * 那么任何线程都可能获得该锁而调用相应的方法；当某一线程请求成功后，JVM会记下锁的持有线程，并且将计数器置为 1；
 * 此时其它线程请求该锁，则必须等待；而该持有锁的线程如果再次请求这个锁，就可以再次拿到这个锁，同时计数器会递增；
 * 当线程退出同步代码块时，计数器会递减，如果计数器为 0，则释放该锁。
 *
 * 另外，当线程请求一个由其它线程持有的对象锁时，该线程会阻塞，
 * 而当线程请求由自己持有的对象锁时，如果该锁是重入锁，请求就会成功，否则阻塞。
 * @author ypy
 */
public class Demo1 {
    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().start();
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        /**
         * synchronized锁对象中有一个计数器(recursions变量)会记录线程获得几次锁。
         * synchronized锁对象的可重入性的优点： 1、避免产生死锁；2、可以更好的封装代码。
         */
        synchronized (MyThread.class){
            System.out.println(getName() + "同步代码块1");

            synchronized (MyThread.class){
                System.out.println(getName() + "同步代码块2");
            }
        }
    }
}
