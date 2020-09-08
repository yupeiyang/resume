package forkandjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * 提交给 Fork/Join 线程池的任务需要继承 RecursiveTask（有返回值）或 RecursiveAction（没有返回值），
 * 例如下面定义了一个对 1~n 之间的整数求和的任务
 * @author ypy
 */
class AddTask1 extends RecursiveTask<Integer>{
    int n;

    public AddTask1(int i) {
        this.n = i;
    }

    @Override
    public String toString() {
        return "AddTask{" +
                "n=" + n +
                '}';
    }

    @Override
    protected Integer compute() {
        if(n == 1){
            return n;
        }

        AddTask1 task1 = new AddTask1(n-1);
        task1.fork();

        int result = n + task1.join();

        return result;
    }
}

/**
 * @author ypy
 */
public class Demo1 {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(4);

        System.out.println(pool.invoke(new AddTask1(100)));
    }
}
