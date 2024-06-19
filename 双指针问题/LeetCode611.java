import java.util.Arrays;

public class LeetCode611 {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ret = 0;
        for (int i = n - 1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                int temp = nums[left] + nums[right];
                if (temp > nums[i]) {
                    ret += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ret;
    }
}
