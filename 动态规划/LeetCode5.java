public class LeetCode5 {
    //给你一个字符串 s，找到 s 中最长的回文
    //子串
    //。
    //
    //如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int max = 0;
        int index1 = 0;
        int index2 = 0;
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

                if (dp[i][j] && max < j - i + 1) {
                    max = j - i + 1;
                    index1 = i;
                    index2 = j;
                }

            }

        }

        return s.substring(index1, index2 + 1);

    }
}
