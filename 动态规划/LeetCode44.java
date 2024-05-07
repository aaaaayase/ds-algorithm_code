public class LeetCode44 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        s = " " + s;
        p = " " + p;

        for (int i = 1; i <= n; i++) {
            if (p.charAt(i) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {
                if (p.charAt(j) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j) == '*') {

                    if (dp[i][j - 1] || dp[i - 1][j]) {
                        dp[i][j] = true;
                    }

                } else {
                    if (s.charAt(i) == p.charAt(j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }

            }

        }
        return dp[m][n];
    }

}
