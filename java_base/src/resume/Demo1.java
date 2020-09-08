package resume;

//Java中基本类型和引用类型的分别
public class Demo1 {
    public void changeValue1(int age){
        age = 30;
        System.out.println("age --- "+age);
    }

    public void changeValue2(Person person){
        person.setName("XXX");
    }

    public void changeValue3(String str){
        str = "XXX";
        System.out.println("str : "+str);
    }


    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        int age = 100;
        demo1.changeValue1(age);
        System.out.println("age --- "+age);

        Person person = new Person("abc");
        //在JVM堆内存的新生代Eden区
        demo1.changeValue2(person);
        System.out.println("person name : "+person.getName());

        //存储在字符串常量池
        String str = "abc";
        demo1.changeValue3(str);
        System.out.println("str : "+str);
    }
}
