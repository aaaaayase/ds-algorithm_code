public class LeetCode10 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 2; i <= n; i += 2) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }

        s = " " + s;
        p = " " + p;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j) == '*') {
                    if (dp[i][j - 2]) {
                        dp[i][j] = true;
                        continue;
                    }
                    if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i)) {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[m][n];
    }

}
