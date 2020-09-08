/**
 * @author ypy
 */
public class Demo1 {
    public static void main(String[] args) {
        Integer i = 100;
        Integer j = 100;

        if(i.equals(j)){
            System.out.println("i.equals(j) = "+i.equals(j));
        }else {
            System.out.println("i.equals(j) != "+i.equals(j));
        }

        /**
         * 非new生成的Integer变量和new Integer()生成的变量比较时，结果为false。
         * 因为非new生成的Integer变量指向的是静态常量池中cache数组,而cache数组中存储的指向了堆中的Integer对象，
         * 而new Integer()生成的变量指向堆中新建的对象，两者在内存中的对象引用（地址）不同。
         */
        Integer m = new Integer(5);
        int n = 5;
        System.out.println(m == n);

        /**
         * 对于两个非new生成的Integer对象，
         * 进行比较时，如果两个变量的值在区间-128到127之间，则比较结果为true，
         * 如果两个变量的值不在此区间，则比较结果为false
         *
         * 解析原因：归结于java对于Integer与int的自动装箱与拆箱的设计，是一种模式：叫享元模式（flyweight）。
         * （1）加大对简单数字的重利用，Java定义在自动装箱时对于在-128~127之内的数值，
         * 它们被装箱为Integer对象后，会存在内存中被重用，始终只存在一个对象。
         * （2）而如果在-128~127之外的数，被装箱后的Integer对象并不会被重用，即相当于每次装箱时都新建一个 Integer对象。
         */
        Integer i1 = 127;
        Integer j1 = 127;
        if(i1 == j1){
            System.out.println("i1 == j1");
        }else {
            System.out.println("i1 != j1");
        }

        Integer i2 = 128;
        Integer j2 = 128;
        if(i2 == j2){
            System.out.println("i2 == j2");
        }else {
            System.out.println("i2 != j2");
        }

        // 声明一个Integer对象，用到了自动的装箱：解析为:Integer num = Integer.valueOf(10);
        Integer num = 10;
        System.out.println("num = "+num);

        //声明一个Integer对象
        Integer num1 = 10;

        // 进行计算时隐含的有自动拆箱
        System.out.print(num1--);
    }
}
