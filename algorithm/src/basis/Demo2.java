package basis;

/**
 * 计算两个大数相加
 * @author ypy
 */
public class Demo2 {
    public static void main(String[] args) {
        String a = "12";
        String b = "999";

        char[] large = null;
        char[] small = null;

        if(a.length() > b.length()){
            large = a.toCharArray();
            small = b.toCharArray();
        }else {
            small = a.toCharArray();
            large = b.toCharArray();
        }

        int[] sums = new int[large.length + 1];

        for(int i = 0;i < large.length;i++){
            sums[i] = large[large.length - i - 1] - '0';
        }

        for(int i = 0;i < small.length;i++){
            sums[i] += small[small.length - i - 1] - '0';
        }

        for(int i = 0;i<sums.length - 1;i++){
            if(sums[i] > 9){
                sums[i + 1] += sums[i] /10;
                sums[i] %= 10;
            }
        }

        StringBuilder builder = new StringBuilder();

        //数组逆置
        for(int i = sums.length - 1;i >= 0;i--){
            builder.append(sums[i]);
        }

        String result = builder.toString();

        if(result.startsWith("0")){
            result = result.substring(1);
        }

        System.out.println(result);
    }
}
