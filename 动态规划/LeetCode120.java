import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TransferQueue;
import java.util.function.DoublePredicate;

public class LeetCode120 {
    //给定一个三角形 triangle ，找出自顶向下的最小路径和。
    //
    //每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];
        dp[0][0] = triangle.get(0).get(0);

        int min = Integer.MAX_VALUE;

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            int j = 1;
            for (; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
            }
            dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
        }

        for (int i = 0; i < m; i++) {
            if (min > dp[m - 1][i]) {
                min = dp[m - 1][i];
            }
        }

        return min;
    }
}
