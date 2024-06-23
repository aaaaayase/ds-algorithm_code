public class LeetCode1658 {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = 0;
        int aim = 0;
        for (int num : nums) {
            sum += num;
        }
        aim = sum - x;
        if (aim < 0) {
            return -1;
        }
        int ret = -1;
        int tmp = 0;
        for (int right = 0, left = 0; right < n; right++) {
            tmp += nums[right];
            while (tmp > aim) {
                tmp -= nums[left];
                left++;
            }
            if (tmp == aim) {
                ret = Math.max(ret, right - left + 1);
            }
        }

        return ret == -1 ? -1 : n - ret;
    }
}
