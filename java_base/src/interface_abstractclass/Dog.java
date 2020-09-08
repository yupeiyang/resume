package interface_abstractclass;

public class Dog extends Animal {
    //super();

    @Override
    public void eat(){
        System.out.println("吃食物了");
    }

    @Override
    public void say(String name){
        System.out.println("动物名为: "+name);
    }

    public void drink(String water){
        System.out.println("喝..."+water);
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
        dog.say("狗");
        dog.drink("可口可乐");
    }
}
