package flyweight;

/**
 * 享元Flyweight模式是构造型模式之一，它通过共享数据使得相同对象在内存中仅创建一个实例，
 * 以降低系统创建对象实例的性能消耗。
 * @author ypy
 */
public class Demo1 {
    public static void main(String[] args) {
        String str1 = "郁培阳";
        String str2 = "郁培阳";

        Integer i = 100;
        Integer j = 100;

        int m = 100;
        int n = 100;

        if(str1 == str2){
            System.out.println("str1 == str2");
        }else {
            System.out.println("str1 != str2");
        }

        if( i.equals(j)){
            System.out.println("i.equals(j) = "+i.equals(j));
        }else{
            System.out.println("i.equals(j) != "+i.equals(j));
        }

        if( m == n){
            System.out.println("m == n "+(m == n));
        }else{
            System.out.println("m != n "+(m == n));
        }
    }
}
