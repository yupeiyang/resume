package atomicinteger;

import java.util.ArrayList;
import java.util.List;

        /**
        * @author ypy
        *
        * 使用多线程并发访问共享数据会出现原子性问题
        *
        * 该程序就并发编程中的原子性问题进行讲解
        * 原子性（Atomicity）：在一次或多次操作中，要么所有的操作都执行并且不会受其他因素干扰而中
        * 断，要么所有的操作都不执行
        *
        * 并发编程时，会出现原子性问题，当一个线程对共享变量操作到一半时，另外的线程也有可能来操作共
        * 享变量，干扰了前一个线程的操作。
        */
public class Demo1 {
    private static int num = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable increment = ()->{
            for(int i = 0;i<1000;i++){
                num++;
            }
        };

        List<Thread> list = new ArrayList<>();

        //创建10个线程进行num累加1000
        for(int i = 0;i <10;i++){
            Thread thread = new Thread(increment);
            thread.start();
            list.add(thread);
        }

        for(Thread thread1:list){
            /**
             * 主线程启动子线程，如果子线程中要进行大量的耗时运算，主线程会早于子线程结束，
             * 这时候主线程如果想等待子线程完成之后再运行，就需要join()方法,
             * 通常用于在main()主线程内，等待其它线程完成再结束main()主线程
             */
            thread1.join();
        }

        System.out.println("num = "+num);
    }
}
