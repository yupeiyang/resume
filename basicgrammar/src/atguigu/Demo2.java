package atguigu;

public class Demo2 {
    public static void main(String[] args) {
        String str = "";
        for(int i = 0;i<5;i++){
            str+=i;
        }
        System.out.println(str);

        int num = 2147483647;
        num +=2L;
        System.out.println(num);
    }
}
