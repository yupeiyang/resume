package day1.lengthOfLongestSubstring3;

import java.util.HashMap;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class Demo1 {
    public static int lengthOfLongestSubstring(String s){
        int res = 0;
        if(s.length() == 0){
            return res;
        }
        //创建HashMap，用来保存字符与位置之间的对应关系
        HashMap<Character,Integer> hashMap = new HashMap<Character,Integer>();

        //初始化左指针和右指针，并遍历字符串
        for(int left = 0,right = 0;right<s.length();right++){
            //判断右指针指向的字符是否出现过
            if(hashMap.containsKey(s.charAt(right))){
                //确定左指针的位置，Math.max(参数1，参数2)是一个静态的工具方法，主要用来比较两个相同类型参数的大小,并返回较大者
                left = Math.max(left,hashMap.get(s.charAt(right))+1);
            }

            //对于第一次出现的字符，保存该字符的位置；对于多次出现的字符，更新该字符出现的位置 ，charAt()方法可返回指定位置的字符
            hashMap.put(s.charAt(right),right);

            //更新窗口的大小，保存最大的窗口大小
            res = Math.max(res, right-left+1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("a"));
    }
}
