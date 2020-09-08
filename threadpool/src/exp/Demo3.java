package exp;

import java.util.concurrent.*;

/**
 * @author ypy
 */
public class Demo3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        // 提交任务 task，用返回值 Future 获得任务执行结果
        Future<String> future = pool.submit(new Callable<String>(){
            @Override
            public String call() throws Exception {
                Thread.sleep(3000);
                return "OK";
            }
        });

        System.out.println(future.get());

        pool.shutdown();
    }
}
