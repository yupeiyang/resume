package exp;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledExecutorService 延时执行
 * @author ypy
 */
public class Demo6 {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        // 添加两个任务，希望它们都在 1s 后执行
        executor.schedule(() -> {
            System.out.println("任务1，执行时间：" + new Date());
            try { Thread.sleep(2000); } catch (InterruptedException e) { }
        }, 2000, TimeUnit.MILLISECONDS);

        executor.schedule(() -> {
            System.out.println("任务2，执行时间：" + new Date());
        }, 4000, TimeUnit.MILLISECONDS);

        executor.schedule(() -> {
            System.out.println("任务3，执行时间：" + new Date());
        }, 6000, TimeUnit.MILLISECONDS);

        executor.schedule(() -> {
            int i = 1/0;
            System.out.println("任务4，执行时间：" + new Date());
        }, 8000, TimeUnit.MILLISECONDS);

        executor.shutdown();
    }
}
