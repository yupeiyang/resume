package reflect;

import reflect.domain.Person;

/**
 * 反射：框架设计的灵魂
 * 反射：将类的各个组成部分封装为其他对象，这就是反射机制。
 * 反射的好处：
 *      1、可在程序运行过程中，操作这些对象。
 *      2、可以解耦，提高程序的可扩展性。
 * 反射机制获取class对象的方式：
 *      1、通过Class.forName("全路径类名"):将字节码文件加载进内存，返回class对象。多用于配置文件。
 *      2、类名.class :通过类名的属性class获取。多用于参数传递。
 *      3、对象.getClass()：getClass()方法在Object类中有定义。多用于对象获取字节码方式。
 */
public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        //1、通过Class.forName("全路径类名"):将字节码文件加载进内存，返回class对象。
        Class cls1 = Class.forName("reflect.domain.Person");
        System.out.println(cls1);
        System.out.println(System.identityHashCode(cls1));
        //2、类名.class :通过类名的属性class获取。
        Class cls2 = Person.class;
        System.out.println(cls2);
        System.out.println(System.identityHashCode(cls2));
        //3、对象.getClass()：getClass()方法在Object类中有定义。
        Class cls3 = new Person().getClass();
        System.out.println(cls3);
        System.out.println(System.identityHashCode(cls3));
        //总结：同一字节码文件在一次运行过程中，只会被加载一次，以上三种方式获取到都是同一个class对象。
    }
}


