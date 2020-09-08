package exp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ypy
 */
public class Demo5 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        pool.execute(() -> {
            System.out.println("1");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        pool.execute(() -> {
            System.out.println("2");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        pool.execute(() -> {
            System.out.println("3");
        });

        /**
         * 线程池状态变为 STOP
         * - 不会接收新任务
         * - 会将队列中的任务返回
         * - 并用 interrupt 的方式中断正在执行的任务
         */
        pool.shutdownNow();
    }
}
