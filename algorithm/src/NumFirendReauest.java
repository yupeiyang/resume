public class NumFirendReauest {
    public static int numFriendRequests(int[] ages) {
        int[] nums = new int[122];
        for (int age : ages) {
            nums[age] ++;
        }

        int count = 0;
        for (int i = 120; i >= 1; i --) {
            if (nums[i] == 0) {
                continue;
            }
            if (i > 0.5 * i + 7) {
                count += nums[i] * (nums[i] - 1);
            }
            for (int j = i - 1; j >= 1; j --) {
                if (j <= 0.5 * i + 7) {
                    break;
                } else {
                    count += nums[j] * nums[i];
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] ages = {16,17,18};
        System.out.println(numFriendRequests(ages));
    }
}
