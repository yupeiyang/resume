package exp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ypy
 */
public class Demo1 {
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

        pool.shutdown();
    }
}
