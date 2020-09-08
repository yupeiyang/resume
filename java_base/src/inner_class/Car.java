package inner_class;

public class Car {
    //匿名内部类
    public abstract static class Carlight {
        public abstract void show();
    }

    //成员内部类实例
    class Engine{
        Engine(){
            System.out.println("Car->Engine");
        }

        public void run(String name){
            System.out.println("发动机运行起来了："+name);
        }
    }

    public static void main(String[] args) {
        //成员内部类
        Car.Engine engine = new Car().new Engine();
        engine.run("马自达");

        //匿名内部类
        Carlight carlight = new Carlight(){
            public void show(){
                System.out.println("Car -> Carlight ... 车灯亮了。");
            }
        };
        carlight.show();
    }
}
