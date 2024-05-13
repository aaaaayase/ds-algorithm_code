public class LeetCode712 {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + (int) s1.charAt(i - 1);
                }
                dp[i][j] = Math.max(dp[i][j], Math.max(dp[i][j - 1], dp[i - 1][j]));
                max = Math.max(max, dp[i][j]);
            }
        }

        int ret = 0;
        for (int x :
                s1.toCharArray()) {
            ret += x;
        }


        for (int x :
                s2.toCharArray()) {
            ret += x;
        }

        return ret - 2 * max;

    }
}
