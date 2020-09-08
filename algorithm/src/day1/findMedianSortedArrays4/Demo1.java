package day1.findMedianSortedArrays4;

/**
 * 4. 寻找两个正序数组的中位数难度困难2927给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空
 */
public class Demo1 {
    public static double findMedianSortedArrays(int[] nums1,int[] nums2){
        double mid1 = 0,mid2 = 0;

        if(nums1 == null || nums1 == null){

        }

        if(nums1.length % 2 ==0){
            mid1 = nums1[nums1.length/2 - 1] + nums1[nums1.length/2];
            mid1 = mid1/2;
        }else{
            int local = nums1.length - 1;
            local = local/2;
            mid1 = nums1[local];
        }

        if(nums2.length % 2 ==0){
            mid2 = nums2[nums2.length/2 - 1] + nums2[nums2.length/2];
            mid2 = mid2/2;
        }else{
            int local = nums2.length - 1;
            local = local/2;
            mid2 = nums2[local];
        }

        if(mid1 == mid2){
            return mid1;
        }else if(mid1 > mid2){
            int[] temp = new int[(nums1.length + 1)/2+(nums2.length + 1)/2];
            int i = 0;

            while (i < (nums2.length - 1)/2){
                temp[i] = nums2[i];
                i++;
            }

            while (i < (nums1.length + 1)/2+(nums2.length + 1)/2){
                temp[i] = nums1[i];
                i++;
            }

            return temp.length % 2 != 0 ? (double)temp[(temp.length)/2]:(double)(temp[temp.length/2 - 1] + temp[temp.length/2])/2;
        }else {
            int[] temp = new int[(nums1.length + 1)/2+(nums2.length + 1)/2];
            int i = 0;

            while (i < (nums1.length + 1)/2){
                temp[i] = nums1[i+2];
                i++;
            }

            while (i < (((nums1.length + 1)/2+(nums2.length + 1)/2))){
                temp[i] = nums2[i-2];
                i++;
            }
            return temp.length % 2 != 0 ? (double) temp[(temp.length)/2]:(double) (temp[temp.length/2 - 1] + temp[temp.length/2])/2;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6};
        int[] arr2 = {4,5,6,7,8,9};

        System.out.println(findMedianSortedArrays(arr1,arr2));
    }
}
