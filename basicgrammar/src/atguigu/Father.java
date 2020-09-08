package atguigu;

/**
 * 类的实例化：执行<clinit>()方法，且只执行一次
 * <clinit>()方法执行：静态类变量显示复制代码和静态代码块按顺序执行
 */
public class Father {
    private int i = test();
    private static int j = method();

    static {
        System.out.print("1\t");
    }

    Father(){
        System.out.print("2\t");
    }

    {
        System.out.print("3\t");
    }

    public int test(){
        System.out.print("4\t");
        return 1;
    }

    public static int method(){
        System.out.print("5\t");
        return 1;
    }
}
