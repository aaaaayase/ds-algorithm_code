public class LeetCode1004 {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int zero = 0; // 0的个数
        int ret = 0; // 返回的最大个数
        for (int right = 0, left = 0; right < n; right++) {
            if (nums[right] == 0) {
                zero++; // 进窗口的同时统计0的个数
            }
            while (zero > k) { // 判断是否达到最大0的个数
                if (nums[left] == 0) {
                    zero--; // 出窗口
                }
                left++;
            }
            ret = Math.max(ret, right - left + 1); // 更新返回值
        }

        return ret;
    }
}
