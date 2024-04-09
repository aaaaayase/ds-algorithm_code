public class LeetCode1745 {
    //给你一个字符串 s ，如果可以将它分割成三个 非空 回文子字符串，那么返回 true ，否则返回 false 。
    //
    //当一个字符串正着读和反着读是一模一样的，就称其为 回文字符串 。


    public boolean checkPartitioning(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j) {
                        dp[i][j] = true;
                    } else if (i + 1 == j) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = i; j < n - 1; j++) {
                if (dp[0][i - 1] && dp[i][j] && dp[j + 1][n - 1]) {
                    return true;
                }
            }
        }

        return false;
    }

}
