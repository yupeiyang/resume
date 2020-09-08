package basis;

//递归实例：累加计算
public class Demo1 {
    public static int getLeiJia(int num){
        if(num == 0 || num == 1){
            return num;
        }else {
            return getLeiJia(num - 1) + num;
        }
    }

    public static void main(String[] args) {
        System.out.println(getLeiJia(9));
    }
}
