package uninterruptibility;

/**
 * @author ypy
 *
 * 演示synchronized的不可中断性
 * 1、定义一个Runnable
 * 2、在Runnable中定义同步代码块
 * 3、先开启一个线程来执行同步代码块，保证不退出同步代码块
 * 4、后开启一个线程来执行同步代码块(阻塞状态)
 * 5、停止第二个线程
 */
public class Demo1 {
    private static Object object = new Object();
    public static void main(String[] args) {
        Runnable runnable = () -> {
            synchronized (object){
                String name = Thread.currentThread().getName();
                System.out.println(name + "进入同步代码块");
                try{
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(name+"在同步代码块中，此时的线程状态为"+Thread.currentThread().getState());
            }
        };
        Thread thread0 = new Thread(runnable);
        thread0.start();
        Thread thread1 = new Thread(runnable);
        thread1.start();

        System.out.println("thread-0线程的状态"+thread0.getState());
        System.out.println("thread-1线程的状态"+thread1.getState());

        System.out.println("对thread-1线程尝试进行中断");
        //由于synchronized的不可中断性，使得thread1线程并不能被中断
        thread1.interrupt();
        System.out.println("对thread-1线程尝试进行中断后");
        //System.out.println("thread-1线程的状态"+thread1.getState());

        System.out.println("thread-0线程的状态"+thread0.getState());
        System.out.println("thread-1线程的状态"+thread1.getState());
    }
}
