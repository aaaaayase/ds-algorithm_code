import java.util.HashMap;
import java.util.Map;

public class LeetCode873 {

    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        Map<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < n; i++) {
            hash.put(arr[i], i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 2;
            }
        }


        int ret = 2;
        for (int j = 2; j < n; j++) {

            for (int i = 1; i < j; i++) {
                int temp = arr[j] - arr[i];
                if (temp < arr[i] && hash.containsKey(temp)) {
                    dp[i][j] = dp[hash.get(temp)][i] + 1;
                }

                ret = Math.max(ret, dp[i][j]);
            }


        }

        return ret < 3 ? 0 : ret;
    }
}
