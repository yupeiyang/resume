package exp;

import java.util.concurrent.*;

/**
 * 正确处理执行任务异常： 1、try/catch语句进行捕获
 * 2、使用Future
 * @author ypy
 */
public class Demo7 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        //使用Future可以正确处理执行任务异常
        Future future = pool.submit(() -> {
            System.out.println("固定线程池");

            int i = 1/0;
        });

        System.out.println(future.get());
    }
}


