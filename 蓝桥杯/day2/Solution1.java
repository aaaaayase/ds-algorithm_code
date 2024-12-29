

/**
 * @author yun
 * @date 2024/12/28 11:49
 * @desciption: 三步问题
 */
public class Solution1 {
    public int waysToStep(int n) {
        if(n==1) {
            return 1;
        } else if(n==2) {
            return 2;
        }
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++) {
            dp[i]=((dp[i-1]+dp[i-2])%1000000007+dp[i-3])%1000000007;
        }

        return dp[n];
    }
}
