import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode446 {
    //给你一个整数数组 nums ，返回 nums 中所有 等差子序列 的数目。
    //
    //如果一个序列中 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该序列为等差序列。
    //
    //例如，[1, 3, 5, 7, 9]、[7, 7, 7, 7] 和 [3, -1, -5, -9] 都是等差序列。
    //再例如，[1, 1, 2, 5, 7] 不是等差序列。
    //数组中的子序列是从数组中删除一些元素（也可能不删除）得到的一个序列。
    //
    //例如，[2,5,10] 是 [1,2,1,2,4,1,5,10] 的一个子序列。
    //题目数据保证答案是一个 32-bit 整数。
    public int numberOfArithmeticSlices(int[] nums) {

        int n = nums.length;
        int[][] dp = new int[n][n];

        Map<Long, List<Integer>> hash = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Long temp = 1L * nums[i];
            if (!hash.containsKey(temp)) {
                hash.put(temp, new ArrayList<Integer>(i));
            }
            hash.get(temp).add(i);
        }

        int sum = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Long temp = 2L * nums[i] - nums[j];
                if (hash.containsKey(temp)) {
                    for (int l = 0; l < hash.get(temp).size(); l++) {
                        if (hash.get(temp).get(l) < i) {
                            dp[i][j] += dp[hash.get(temp).get(l)][i] + 1;
                        } else {
                            break;
                        }

                    }
                }
                sum += dp[i][j];
            }

        }

        return sum;
    }
}
