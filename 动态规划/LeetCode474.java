import java.util.ArrayList;
import java.util.List;

public class LeetCode474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len + 1][m + 1][n + 1];

        for (int i = 1; i <= len; i++) {
            int count0 = 0;
            int count1 = 0;
            for (char ch : strs[i - 1].toCharArray()) {
                if (ch == '0') {
                    count0++;
                } else {
                    count1++;
                }
            }
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j - count0 >= 0 && k - count1 >= 0) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - count0][k - count1] + 1);
                    }
                }
            }

        }
        return dp[len][m][n];

    }
}
