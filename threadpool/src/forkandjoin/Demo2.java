package forkandjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class AddTask2 extends RecursiveTask<Integer> {
    int begin,end;

    public AddTask2(int begin,int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if(begin == end){
            return begin;
        }

        if(end - begin == 1){
            return begin + end;
        }

        int mid = (begin + end)/2;

        AddTask2 task1 = new AddTask2(begin,mid);
        task1.fork();

        AddTask2 task2 = new AddTask2(mid+1,end);
        task2.fork();

        int result = task1.join() + task2.join();
        return result;
    }
}

/**
 * @author ypy
 */
public class Demo2 {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(4);
        System.out.println(pool.invoke(new AddTask2(1,100)));
    }
}
