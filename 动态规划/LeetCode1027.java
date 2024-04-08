import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode1027 {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 2;
            }
        }

        int ret = 2;
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                int temp = 2 * nums[i] - nums[j];
                int end = i - 1;
                if (getIndex(nums, temp, end) != -1) {
                    dp[i][j] = Math.max(dp[i][j], dp[getIndex(nums, temp, end)][i] + 1);
                    end = getIndex(nums, temp, end) - 1;
                }
                ret = Math.max(ret, dp[i][j]);
            }

        }

        return ret;

    }

    public int getIndex(int[] nums, int target, int end) {
        for (int i = end; i >= 0; i--) {
            if (target == nums[i]) {
                return i;
            }
        }

        return -1;
    }

}
