package ordering;

/**
 * @author ypy
 *  使用多线程并发访问共享数据会出现有序性问题
 * 有序性：是指程序的执行顺序，java在编译和运行时会对代码进行优化，会导致程序最终的执行顺序和编码时的顺序不同
 */
public class Demo3 {
    /**
     * volatile修饰的变量不会发生重排序
     */
    static volatile int a = 0,b = 0,x = 0,y = 0;
    /**
     * 定义锁对象
     */
    private static Object object = new Object();
    public static void main(String[] args) throws InterruptedException{
        //int a = 0,b = 0,x = 0,y = 0;
        /**
         * 为了提高程序的执行效率，编译器和CPU会对程序中的代码进行重排序
         *
         * 指令重拍一般不会导致数据不安全、不唯一，
         * 但是读后写、写后写、写后读数据相关的指令重拍（了解一下）会导致的数据不唯一的问题，
         * 即操作系统的读后写、写后写、写后读数据相关导致的数据不一致问题
         *
         * 解决以上现象：as-if-serial语句：不管编译器和CPU如何重排序，必须保证单线程情况下，程序运算结果正确
         */
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                a = 10;
                x = b;
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                b = 10;
                y = a;
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        //x、y的值不唯一，指令重拍一般不会导致数据不安全、不唯一，但是读后写、写后写、写后读数据相关的指令重拍（了解一下）会导致的数据不唯一的问题，即操作系统的读后写、写后写、写后读数据相关导致的数据不一致问题
        System.out.println("x = "+x+"\n"+"y = "+y+"\nx + y = "+(x+y));
    }
}
