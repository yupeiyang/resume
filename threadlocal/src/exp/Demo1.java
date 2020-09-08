package exp;

/**
 * @author ypy
 * @date 2020/7/22
 */
public class Demo1 {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();

        for(int i = 0;i<9;i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    demo1.setContent(" -> "+Thread.currentThread().getName()+"数据");
                    System.out.println("----------------------");
                    System.out.println(Thread.currentThread().getName()+demo1.getContent());
                }
            });

            thread.setName("线程"+(i+1));
            thread.start();
        }
    }
}
