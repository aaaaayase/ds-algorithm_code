public class LeetCode209 {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, n = nums.length, len = Integer.MAX_VALUE;
        for (int left = 0, right = 0; right < n; right++) {
            sum += nums[right]; // 进窗口
            while (sum >= target) {
                len = Math.min(len, right - left + 1); // 更新结果
                sum -= nums[left]; // 出窗口
                left++;
            }
        }

        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
