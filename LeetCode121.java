public class LeetCode121 {
    //给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
    //
    //你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
    //
    //返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
    public int maxProfit(int[] prices) {
        //return maxProfit1(prices);
        return maxProfit2(prices);
    }

    public int maxProfit1(int[] prices) {
        int max=0;
        for(int i=0;i<prices.length-1;i++) {
            int purchase=prices[i];

            for(int j=i+1;j<prices.length;j++) {
                int sold=prices[j];
                int temp=sold-purchase;
                if(temp>max) {
                    max=temp;
                }
            }

        }

        if(max<=0) {
            return 0;
        }

        return max;
    }

    public int maxProfit2(int[] prices) {
        int min=Integer.MAX_VALUE;
        int maxP=0;
        for(int i=0;i<prices.length;i++) {

            if(prices[i]<min) {
                min=prices[i];
            } else if(maxP<prices[i]-min) {

                maxP=prices[i]-min;


            }

        }

        return maxP;
    }
}
