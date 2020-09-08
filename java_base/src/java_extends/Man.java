package java_extends;

public class Man extends Person {
    Man(String name,int age){
        super("yupeiyang",29);
        System.out.println("Person的信息是：\tname : "+name+"\t age : "+age);
    }

    @Override
    public void eat(){
        super.eat();
        System.out.println("eat ....");
    }

    @Override
    public void drink(String water){
        super.drink("芬达");
        System.out.println("喝 ..."+water+"美滋滋！");
    }

    public static void main(String[] args) {
        Man man = new Man("wangwenjuan",25);
        man.eat();
        man.drink("可口可乐 雪碧 ");
    }
}
