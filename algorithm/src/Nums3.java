public class Nums3 {
    public static void moveZeroes(int[] nums){
        int num0 = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 0){
                num0++;
            }else if(num0 != 0){
                //nums[i-num0] = nums[i];
                //nums[i] = 0;
                int temp = nums[i-num0];
                nums[i-num0] = nums[i];
                nums[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        //int[] nums = new int[]{19,0,3,32,0,11,0,3};
        int[] nums = new int[]{11,0,0,0,0,0,0,3};
        moveZeroes(nums);
        for(int i = 0;i<nums.length;i++){
            System.out.print(nums[i]+"\t");
            System.out.println("");
        }
    }
}
