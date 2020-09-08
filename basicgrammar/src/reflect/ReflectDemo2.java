package reflect;

import reflect.domain.Person;

import java.lang.reflect.Field;

public class ReflectDemo2 {
    public static void main(String[] args) throws Exception {
        Person person = new Person();
        Class cls1 = person.getClass();

        //cls1.getFields() : 获取class类对象的所有的public修饰的成员变量。
        Field[] fields = cls1.getFields();
        for(Field field:fields){
            System.out.println(field);
        }

        //cls1.getDeclaredFields() : 获取class对象的所有的成员变量包括私有、保护。
        Field[] fields1 = cls1.getDeclaredFields();
        for(Field field:fields1){
            System.out.println(field);
        }

        //cls1.getDeclaredField(String name) : 获取单个成员变量
        Field field1 = cls1.getDeclaredField("str3");
        Field field2 = cls1.getDeclaredField("str4");
        field1.setAccessible(true); //暴力反射
        field2.setAccessible(true); //暴力反射
        Object object1 = field1.get(person);
        Object object2 = field2.get(person);
        System.out.println(object1);
        System.out.println(object2);
    }
}
