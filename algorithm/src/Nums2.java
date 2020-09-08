public class Nums2 {
    public static void moveZeroes(int[] nums) {
        int zeroNum=0;//用来计算0的个数
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){//如果nums[i]=0,zeroNum个数加一
                zeroNum++;
            }else if(zeroNum!=0){//如果nums[i]不等于0,将nums[i]跟前zeroNum个交换，并且将nums[i]赋值为0
                nums[i-zeroNum]=nums[i];
                nums[i]=0;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{19,0,3,32,0,11,0,3};
        //int[] nums = new int[]{0,7,0,3};
        //int[] nums = new int[]{10,0,0,0,0};
        moveZeroes(nums);
        for(int i = 0;i<nums.length;i++){
            System.out.print(nums[i]+"\t");
        }
    }
}
