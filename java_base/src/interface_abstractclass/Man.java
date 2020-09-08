package interface_abstractclass;

public class Man extends Thing implements Person {

    @Override
    public void name(String name) {
        System.out.println("姓名是..."+name);
    }

    @Override
    public void show1() {
        System.out.println("show1() 一下");
    }
    //如果子类继承父类，父类中有b方法，该子类同时实现的接口中也有b方法（被default修饰），
    //那么子类会继承父类的b方法而不是继承接口中的b方法
    public static void main(String[] args) {
        Man man1 = new Man();
        man1.name("李白");
        man1.show();
        man1.show1();
        man1.show2();
        //man1.run() 静态方法run无法继承方法,也无法调用;
        Person.run();
    }
}
