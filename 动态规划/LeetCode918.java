public class LeetCode918 {

    //给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。
    //
    //环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。
    //
    //子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。
    //
    //形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int min = minSubarraySum(nums);
        if (min == sum) {
            return maxSubarraySum(nums);
        }

        int max = maxSubarraySum(nums);

        return Math.max(sum - min, max);

    }

    public int maxSubarraySum(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n + 1];
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i - 1], nums[i - 1]);

            if (max < dp[i]) {
                max = dp[i];
            }

        }

        return max;
    }

    public int minSubarraySum(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            dp[i] = Math.min(nums[i - 1], dp[i - 1] + nums[i - 1]);

            if (min > dp[i]) {
                min = dp[i];
            }

        }

        return min;
    }


}
