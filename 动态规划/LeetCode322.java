public class LeetCode322 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int INF = 0x3f3f3f3f;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[0][i] = INF;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= coins[i - 1]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - coins[i - 1]] + 1);

                }

            }
        }

        return dp[n][amount] >= INF ? -1 : dp[n][amount];

    }
}
