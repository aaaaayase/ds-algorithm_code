public class LeetCode400 {

    //给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
    //
    //子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的
    //子序列
    //。
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }


        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }

            }

            if (max < dp[i]) {
                max = dp[i];
            }

        }

        return max;
    }
}
