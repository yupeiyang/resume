package reflect;

import reflect.domain.Person;

import java.lang.reflect.Constructor;

public class ReflectDemo3 {
    public static void main(String[] args) throws Exception {
        Class cls1 = Person.class;

        Constructor constructor1 = cls1.getConstructor(String.class,int.class);
        Constructor constructor2 = cls1.getConstructor();
        System.out.println(constructor1);
        System.out.println(constructor2);

        Object object1 = constructor1.newInstance("王阳明",1147);
        System.out.println(object1);
        Object object2 = constructor2.newInstance();
        System.out.println(object2);
        Object object3 = cls1.newInstance();
        System.out.println(object3);
    }
}
