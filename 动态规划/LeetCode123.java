public class LeetCode123 {
    //给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
    //
    //设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
    //
    //注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    public int maxProfit(int[] prices) {

        int n = prices.length;

        int[][] f = new int[n][3];
        int[][] g = new int[n][3];


        f[0][0] = -prices[0];
        f[0][1] = -0x3f3f3f;
        f[0][2] = -0x3f3f3f;

        g[0][1] = -0x3f3f3f;
        g[0][2] = -0x3f3f3f;


        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                f[i][j] = Math.max(f[i - 1][j], g[i - 1][j] - prices[i]);
                g[i][j] = g[i - 1][j];
                if (j - 1 >= 0) {
                    g[i][j] = Math.max(g[i - 1][j], f[i - 1][j - 1] + prices[i]);
                }
            }


        }


        return Math.max(g[n - 1][0], Math.max(g[n - 1][1], g[n - 1][2]));
    }
}
