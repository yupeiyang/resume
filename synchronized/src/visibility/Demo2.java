package visibility;

/**
 * @author ypy
 * @date 2020/5/11
 *
 * 使用多线程并发访问共享数据会出现可见性问题
 *
 * 可见性(Visibility):当一个线程修改了共享变量时，另一个线程可以读取到这个修改后的值
 *
 * 注意：不应该显示创建线程，应该使用线程池创建线程，本段程序仅用于演示
 */
public class Demo2 {
    /**
     * flag 共享变量，用于测试可见性
     */
    private static volatile boolean flag = true;
    public static void main(String[] args) throws InterruptedException{
        while(true){
            new Thread(()->{
                while (flag){
                    System.out.println("1111111111");
                }
            }).start();

            //休眠2秒
            Thread.sleep(2000);

            new Thread(()->{
                //改变共享变量
                flag = false;
                System.out.println("2222222222");
            }).start();
        }
    }
}
