package exp;

/**
 * @author ypy
 * @date 2020/7/22
 */
public class Demo2 {
    //定义ThreadLocal,将线程内的局部变量进行线程隔离，不能跨线程访问局部变量
    ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public String getContent() {
        //获取当前线程绑定的变量
        return threadLocal.get();
    }

    public void setContent(String content) {
        //将变量绑定到当前线程
        threadLocal.set(content);
    }

    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();

        for(int i = 0;i<9;i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    demo2.setContent(" -> "+Thread.currentThread().getName()+"数据");
                    System.out.println("----------------------");
                    System.out.println(Thread.currentThread().getName()+demo2.getContent());
                }
            });

            thread.setName("线程"+(i+1));
            thread.start();
        }
    }
}
