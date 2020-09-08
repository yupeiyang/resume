package singleton;

/**
 * 饿汉式：
 * 直接创建实例对象，不管你是否需要这个对象.
 * 1、构造器私有化
 * 2、自行创建提供这个实例
 * 3、向外提供这个实例
 * 4、强调这是一个单例，我们用final修饰
 */
public class Singleton1 {
    public static final Singleton1 INSTANCE = new Singleton1();
    private Singleton1(){
        //
    }
}
