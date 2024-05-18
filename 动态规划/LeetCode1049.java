public class LeetCode1049 {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;

        for (int x : stones) {
            sum += x;
        }
        int aim = sum / 2;

        int[][] dp = new int[n + 1][aim + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= aim; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= stones[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j - stones[i - 1]] + stones[i - 1], dp[i][j]);
                }

            }
        }
        return Math.abs(2 * dp[n][aim] - sum);
    }
}
