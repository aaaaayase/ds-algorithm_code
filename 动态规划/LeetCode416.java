public class LeetCode416 {
    public boolean canPartition(int[] nums) {
        int m = nums.length;
        int n = 0;

        for (int x : nums) {
            n += x;
        }

        if (n % 2 != 0) {
            return false;
        }

        n = n / 2;

        boolean[] dp = new boolean[n + 1];

        dp[0] = true;
        for (int i = 1; i <= m; i++) {
            dp[0] = true;
        }

        for (int i = 1; i <= m; i++) {

            for (int j = n; j >= nums[i - 1]; j--) {

                dp[j] = dp[j] || dp[j - nums[i - 1]];

            }
        }

        return dp[n];

    }
}
