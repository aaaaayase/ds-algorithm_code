public class LeetCode122 {
    //给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
    //
    //在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
    //
    //返回 你能获得的 最大 利润 。
    public int maxProfit(int[] prices) {

        //return maxProfit1(prices);
        return maxProfit2(prices);
    }

    public int maxProfit1(int[] prices) {
        //动态规划
        int len=prices.length;
        if(len<2) {
            return 0;
        };

        int cash=0;
        int hold=-prices[0];

        int preCash=cash;
        int preHold=hold;

        for(int i=1;i<len;i++) {
            cash=Math.max(preCash,preHold+prices[i]);
            hold=Math.max(preHold,preCash-prices[i]);

            preCash=cash;
            preHold=hold;

        }
        return cash;
    }

    public int maxProfit2(int[] prices) {
        int len=prices.length;

        if(len<2) {
            return 0;
        }

        int res=0;
        for(int i=1;i<prices.length;i++) {
            res+=Math.max(prices[i]-prices[i-1],0);
        }

        return res;
    }
}
