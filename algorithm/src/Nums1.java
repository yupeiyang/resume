public class Nums1 {
    public static void moveZeroes(int[] nums){
        for(int i = 0;i< nums.length;i++){
            if(nums[i] ==0){
                for(int j = i;j<nums.length+1;j++){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        //int[] nums = new int[]{19,0,3,32,0,11,0,3};
        int[] nums = new int[]{0,0,3};
        moveZeroes(nums);
        for(int i = 0;i<nums.length;i++){
            System.out.print(nums[i]+"\t");
            System.out.println("");
        }
    }
}
