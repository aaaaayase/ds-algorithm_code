/**
 * @author yun
 * @date 2025/4/29 22:51
 * @desciption:
 */
public class LeetCode32 {
    public int longestValidParentheses(String s) {
        int n = s.length();

        int[] dp = new int[n];
        int ret = 0;
        for (int i = 1; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 > -1 ? dp[i - dp[i - 1] - 2] : 0);
                }
                ret = Math.max(ret, dp[i]);
            }
        }

        return ret;
    }

}
