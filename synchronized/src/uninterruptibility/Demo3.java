package uninterruptibility;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ypy
 *
 * 演示Lock的可中断特性
 */
public class Demo3 {
    //定义Lock对象
    private static Lock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        test();
    }

    //演示Lock的可中断性,Lock的tryLock方法是可中断的
    public static void test() throws InterruptedException{
        Runnable runnable = () -> {
            String name = Thread.currentThread().getName();
            boolean flag = false;
            try{
                flag = lock.tryLock(2, TimeUnit.SECONDS);
                if(flag){
                    System.out.println(name+"获取锁");
                    Thread.sleep(4000);
                }else {
                    System.out.println(name+"指定时间内没有获得锁");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if(flag){
                    lock.unlock();
                    System.out.println(name+"释放锁");
                }
            }
        };

        Thread thread0 = new Thread(runnable);
        thread0.start();
        Thread.sleep(1000);
        Thread thread1 = new Thread(runnable);
        thread1.start();
    }
}
