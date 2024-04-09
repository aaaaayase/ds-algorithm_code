public class LeetCode647 {
    //给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
//
//回文字符串 是正着读和倒过来读一样的字符串。
//
//子字符串 是字符串中的由连续字符组成的一个序列。
//
//具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
    public int countSubstrings(String s) {
        int n = s.length();
        char[] str = s.toCharArray();

        boolean[][] dp = new boolean[n][n];

        int sum = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (str[i] == str[j]) {
                    if (i == j) {
                        dp[i][j] = true;
                    } else if (i + 1 == j) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }

                    if (dp[i][j]) {
                        sum++;
                    }
                }
            }
        }

        return sum;

    }

}
