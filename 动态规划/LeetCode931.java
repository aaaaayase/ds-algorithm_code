public class LeetCode931 {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m + 1][n + 2];

        for (int i = 1; i < m + 1; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < m + 1; i++) {
            dp[i][n + 1] = Integer.MAX_VALUE;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j + 1]), dp[i - 1][j - 1]) + matrix[i - 1][j - 1];
            }

        }
        for (int i = 1; i <= n; i++) {
            if (min > dp[m][i]) {
                min = dp[m][i];
            }
        }

        return min;
    }
}
