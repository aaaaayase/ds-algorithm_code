/**
 * @author yun
 * @date 2024/12/28 11:49
 * @desciption: 最长回文子串
 */
public class Solution2 {
    public String longestPalindrome(String _s) {
        char[] s = _s.toCharArray();
        int n = s.length;
        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int end = 0;
        int len = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < n; j++) {
                if (s[i] == s[j]) {
                    if (j - i == 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }

                }

                if (dp[i][j] && (j - i + 1 >= len)) {
                    start = i;
                    end = j;
                    len = j - i + 1;
                }
            }
        }

        return _s.substring(start, end + 1);
    }
}
