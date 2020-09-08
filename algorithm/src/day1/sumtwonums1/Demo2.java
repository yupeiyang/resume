package day1.sumtwonums1;

import java.util.HashMap;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Demo2 {
    public static void main(String[] args) {
        int[] exp={0,1,2,3,4,5,6,7,8,9};
        int target = 8;

        int[] temp = twoSum(exp,target);

        for(int j = 0;j<temp.length;j++){
            System.out.print(temp[j]+"\t");
            if(j%2 == 1){
                System.out.println();
            }

            //将结果数组尾部的0元素去除
            if(temp[j] != 0 && j+1 < temp.length && temp[j+1] == 0){
                break;
            }
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[10];
        int count = 0;

        if(nums.length <= 1)
            return res;

        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0;i<nums.length;i++){
            //key:数组元素，value:数组元素下标
            map.put(nums[i],i);
        }

        for(int i = 0;i<nums.length;i++) {
            int num = nums[i];
            int val = target - num;

            //数组中同一个元素不能使用两遍，使用 num != val 排除
            if (map.containsKey(num) && num != val) {
                if (count <= nums.length - 2) {
                    res[count++] = num;
                    res[count++] = map.get(val);
                } else if (count <= nums.length - 1){
                    res[count++] = num;
                    res[count] = map.get(val);
                }
            }
        }
        return res;
    }
}
