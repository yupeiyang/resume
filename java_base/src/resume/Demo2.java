package resume;

import java.util.HashSet;
import java.util.Set;

public class Demo2 {
    public static void main(String[] args) {
        String s1 = new String("abc");
        String s2 = new String("abc");

        // == 比较值类型，比较的是值是否相等;若比较的是引用类型，比较的是地址是否相等
        System.out.println(s1 == s2); // new 出来的对象(引用类型)的 == 比较，结果都是false.
        System.out.println(s1.equals(s2)); //true : 字符串常量池，equals()方法复写过，即同时复习了hashcode()和equals()

        Set<String> set01 = new HashSet<>(); //HashSet其实就是HashMap,其add()方法，其实就是HashMap的put方法
        set01.add(s1);
        set01.add(s2);
        System.out.println(set01.size()); //因为s1、s2的hashcode相同。因此，set01.size()为1。
        System.out.println("----------------------------");

        Person p1 = new Person("abc");
        Person p2 = new Person("abc");
        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));

        Set<Person> set02 = new HashSet<>();
        set02.add(p1);
        set02.add(p2);
        System.out.println(set02.size()); //因为s1、s2的hashcode相同。因此，set01.size()为1。
    }
}
