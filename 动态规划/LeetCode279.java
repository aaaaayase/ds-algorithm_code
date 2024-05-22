public class LeetCode279 {
    public int numSquares(int n) {
        int[][] dp = new int[(int) Math.sqrt(n) + 1][n + 1];
        int INF = 0x3f3f3f3f;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = INF;
        }
        for (int i = 1; i <= (int) Math.sqrt(n); i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= i * i) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - i * i] + 1);
                }
            }
        }

        return dp[(int) Math.sqrt(n)][n] >= INF ? 0 : dp[(int) Math.sqrt(n)][n];
    }

}
