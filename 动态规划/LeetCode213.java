public class LeetCode213 {
    //你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
    //这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
    //同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
    //给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。

    public int rob(int[] nums) {
        int n = nums.length;

        return Math.max(nums[0] + robChild(nums, 2, n - 2), robChild(nums, 1, n - 1));
    }

    public int robChild(int[] nums, int start, int end) {
        if (start > end) {
            return 0;
        }
        int n = end - start + 1;
        if (n == 0) {
            return 0;
        }
        int[] f = new int[n];
        int[] g = new int[n];

        f[0] = nums[start];

        for (int i = 1; i < n; i++) {
            f[i] = g[i - 1] + nums[start + i];
            g[i] = Math.max(g[i - 1], f[i - 1]);
        }

        return Math.max(f[n - 1], g[n - 1]);
    }
}
