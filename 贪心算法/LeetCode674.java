import java.util.Arrays;

public class LeetCode674 {
    public int findLengthOfLCIS1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        Arrays.fill(dp, 1);
        int ret = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            ret = Math.max(ret, dp[i]);
        }

        return ret;
    }

    public int findLengthOfLCIS(int[] nums) {
        int left = 0;
        int right = 0;
        int ret = 0;
        for (; left < nums.length; ) {
            right = left + 1;
            while (right < nums.length && nums[right] > nums[right - 1]) {
                right++;
            }
            ret = Math.max(ret, right - left);
            left = right;
        }
        return ret;
    }
}
