public class LeetCode17_19 {
    public int[] missingTwo(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum ^= nums[i];
            sum ^= i + 1;
        }
        sum ^= nums.length + 1;
        sum ^= nums.length + 2;

        int temp = sum & (-sum);
        int[] ret = new int[2];
        for (int i = 1; i <= nums.length + 2; i++) {
            if ((temp & i) != temp) {
                ret[0] ^= i;
            } else {
                ret[1] ^= i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if ((temp & nums[i]) != temp) {
                ret[0] ^= nums[i];
            } else {
                ret[1] ^= nums[i];
            }
        }
        return ret;
    }
}
