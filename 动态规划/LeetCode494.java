public class LeetCode494 {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }

        int aim = (sum + target) / 2;
        if (aim < 0 || (sum + target) % 2 == 1) {
            return 0;
        }

        int[][] dp = new int[nums.length + 1][aim + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= nums.length; i++) {

            for (int j = 0; j <= aim; j++) {

                dp[i][j] = dp[i - 1][j];
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[nums.length][aim];
    }
}
