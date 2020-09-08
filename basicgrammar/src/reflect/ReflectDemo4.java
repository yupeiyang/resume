package reflect;

import reflect.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author ypy
 */
public class ReflectDemo4 {
    public static void main(String[] args) throws Exception {
        Class cls1 = Person.class;

        //反射机制获取类对象方法
        Method info = cls1.getMethod("info",String.class,int.class);
        Person person = new Person();
        //执行方法
        info.invoke(person,"薛岳",103);

        System.out.println("---------------------------------------------------------------------------");
        //获取所有的public修饰的方法
        Method[] methods = cls1.getMethods();
        for(Method method:methods){
            System.out.println(method);
            //获取方法名称
            String name = method.getName();
            System.out.println(name);
        }
    }
}
