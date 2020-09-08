package interface_abstractclass;

/**
 * 抽象类可以不包含抽象方法，包含抽象方法的类一定是抽象类，抽象方法zhi必须在子类中dao实现。
 * 当一个方法是抽象的，这意味着这个方法应该被子类的方法覆盖，否则子类的方法仍然是抽象的。
 * 这个子类继承了超类并具有抽象方法，所以它也是一个抽象类，即声明为抽象类。
 * 抽象类不能用新的实例化对象，抽象方法只允许不能实现的声明。
 *
 * 如果一个类包含抽象方法，那么这个类必须用抽象修饰，当然，抽象类也可以没有抽象方法。
 * 抽象类中不存在可以用来阻止对象生成此类的抽象方法。
 * Java中的抽象方法是一种用抽象修饰的方法，它只声明返回的数据类型、方法名和所需的参数，没有方法体，即抽象方法只需要声明而不需要实现。
 */
public abstract class Animal {
    Animal(){
        System.out.println("Animal ...");
    }

    public abstract void eat();
    public abstract void say(String name);

    public void drink(String water){
        System.out.println("喝..."+water);
    }
}
