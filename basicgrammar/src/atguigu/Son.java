package atguigu;

/**
 * 子类的实例化方法：
 * 1、super() 最前面
 * 2、i= test();
 * 3、子类的非静态代码块
 * 4、子类的无参构造函数 最后
 */
public class Son extends Father{
    private int i = test();
    private static int j = method();

    static {
        System.out.print("6\t");
    }

    Son(){
        System.out.print("7\t");
    }

    {
        System.out.print("8\t");
    }

    public int test(){
        System.out.print("9\t");
        return 1;
    }

    public static int method() {
        System.out.print("10\t");
        return 1;
    }

    public static void main(String[] args) {
        /**
         * 包含类初始化和类的实例化过程
         * 父类的类实例化：5、1
         * 子类的类初始化中的super()10、6、9、3、2
         * 子类的实例初始化9、8、7
         */
        Son s1 = new Son();
        System.out.println();

        /**
         * 只包含子类的类初始化和子类的实例初始化：
         * 9、3、2、9、8、7
         */
        Son s2 = new Son();
        System.out.println("\n");
    }
}
