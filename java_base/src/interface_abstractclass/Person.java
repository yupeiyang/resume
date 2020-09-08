package interface_abstractclass;

//所有方法在接口中不能有实现(Java 8 开始接口方法可以有默认实现）
public interface Person {
    public abstract void name(String name);

    public static void sex(){
        System.out.println("每个人都必须有性别。");
    }

    default void show(){
        System.out.println("Person default method show()...");
    }

    public default void show1(){
        System.out.println("Person default method show1()...");
    }

    public default void show2(){
        System.out.println("Person default method show2()...");
    }

    public static void run(){
        System.out.println("static run 一下 ！！！");
    }
}
