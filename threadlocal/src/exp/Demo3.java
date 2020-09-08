package exp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ypy
 * @date 2020/7/22
 */
public class Demo3 {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static void main(String[] args) {
        Demo3 demo3 = new Demo3();

        ExecutorService pool = Executors.newSingleThreadExecutor();

        pool.execute(() -> {
            demo3.setContent(" -> "+Thread.currentThread().getName()+"数据");
            System.out.println(Thread.currentThread().getName()+demo3.getContent());
        });

        pool.shutdownNow();
    }
}
