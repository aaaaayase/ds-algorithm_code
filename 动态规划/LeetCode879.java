public class LeetCode879 {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length;
        int TEMP = (int) 1e9 + 7;
        int[][][] dp = new int[len + 1][n + 1][minProfit + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i][0] = 1;
        }

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= group[i - 1]) {
                        dp[i][j][k] += dp[i - 1][j - group[i - 1]][Math.max(0, k - profit[i - 1])];
                        dp[i][j][k] %= TEMP;
                    }
                }
            }
        }
        return dp[len][n][minProfit];
    }
}
