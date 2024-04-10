public class LeetCode132 {

    //给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是
    //回文串
    //。
    //
    //返回符合要求的 最少分割次数 。
    public int minCut(String s) {

        int n = s.length();
        boolean[][] sup = new boolean[n][n];

        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {

                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j) {
                        sup[i][j] = true;
                    } else if (i + 1 == j) {
                        sup[i][j] = true;
                    } else {
                        sup[i][j] = sup[i + 1][j - 1];
                    }
                }

            }
        }

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < n; i++) {
            if (sup[0][i]) {
                dp[i] = 0;
            } else {
                for (int j = 1; j <= i; j++) {
                    if (sup[j][i]) {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }

            }
        }

        return dp[n - 1];

    }

}

