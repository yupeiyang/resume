import java.util.Scanner;

public class WordNumber1 {
    public static void main(String[] args)
    {
        System.out.println("请输入英语片段,以'.'结束:");
        Scanner scanner = new Scanner(System.in);
        String str = " ";
        int dc = 0;
        int zc = 0;
        while(scanner.hasNext())
        {
            str = scanner.next();
            zc += str.length();
            dc++;
            System.out.println(str);
            if (str.contains("."))
            {
                break;
            }
        }
        System.out.println("单词个数为:" + dc);
        System.out.println("字母数为：" + (zc - 1));
    }
}
