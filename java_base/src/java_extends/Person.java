package java_extends;

public class Person {
    {
        System.out.println("我是静态代码块");
    }

    Person(){

    }

    Person(String name,int age){
        System.out.println("Person的信息是：\tname : "+name+"\t age : "+age);
    }

    public void eat(){
    }

    public void drink(String water){
        System.out.println("喝 ..."+water);
    }
}