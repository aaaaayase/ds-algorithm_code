public class LeetCode188 {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[][] f = new int[n][k + 1];
        int[][] g = new int[n][k + 1];

        f[0][0] = -prices[0];
        for (int i = 1; i < k + 1; i++) {
            f[0][i] = -0x3f3f3f;
            g[0][i] = -0x3f3f3f;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k + 1; j++) {
                f[i][j] = Math.max(f[i - 1][j], g[i - 1][j] - prices[i]);
                g[i][j] = g[i - 1][j];

                if (j - 1 >= 0) {
                    g[i][j] = Math.max(g[i - 1][j], f[i - 1][j - 1] + prices[i]);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < k + 1; i++) {
            if (max < g[n - 1][i]) {
                max = g[n - 1][i];
            }
        }
        return max;
    }
}
