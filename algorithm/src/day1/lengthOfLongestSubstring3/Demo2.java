package day1.lengthOfLongestSubstring3;

import java.util.HashMap;

public class Demo2 {
    public static int lengthOfLongestSubstring(String s){
        int res = 0;
        if(s.length() == 0){
            return res;
        }

        HashMap<Character,Integer> hashMap = new HashMap<Character, Integer>();

        for(int left = 0,right = 0;right<s.length();right++){
            if(hashMap.containsKey(s.charAt(right))){
                left = Math.max(left,hashMap.get(s.charAt(right)) + 1);
            }

            hashMap.put(s.charAt(right),right);

            res = Math.max(res,right - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("adfrsfysdafda"));
    }
}
