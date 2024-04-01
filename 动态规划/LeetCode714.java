public class LeetCode714 {

    //给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
    //
    //你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
    //
    //返回获得利润的最大值。
    //
    //注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        int[][] dp = new int[n][3];

        dp[0][0] = -prices[0];
        dp[0][1] -= fee;

        //0 买入
        //1 卖出
        //2 不买也不卖
        for (int i = 1; i < n; i++) {

            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][2] - prices[i], dp[i - 1][1] - prices[i]));
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i] - fee, dp[i][2] - fee);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);

        }

        return Math.max(Math.max(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
    }
}
