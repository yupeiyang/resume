import java.util.List;

/**
 * @author ypy
 * 输入一行句子，判断句中的单词个数。
 */
public class WordNumeber {
    public static int counter(String stens){
        //List<Byte> byteList = stens.codePointCount(0,-1);
        int cnt = stens.codePointCount(0,160);
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(counter("I am a teacher!"));
    }
}
