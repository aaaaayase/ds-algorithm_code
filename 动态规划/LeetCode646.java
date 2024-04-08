import java.util.Arrays;
import java.util.Comparator;

public class LeetCode646 {
    //给你一个由 n 个数对组成的数对数组 pairs ，其中 pairs[i] = [lefti, righti] 且 lefti < righti 。
    //
    //现在，我们定义一种 跟随 关系，当且仅当 b < c 时，数对 p2 = [c, d] 才可以跟在 p1 = [a, b] 后面。我们用这种形式来构造 数对链 。
    //
    //找出并返回能够形成的 最长数对链的长度 。
    //
    //你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (o1, o2) -> {
            return o1[0] - o2[0];
        });


        int n = pairs.length;
        int[] dp = new int[n];//dp[i]表示以i位置为结尾的最长数对链的长度

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }


        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            max = Math.max(dp[i], max);
        }


        return max;


    }
}
