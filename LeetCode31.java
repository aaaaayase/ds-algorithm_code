/**
 * @author yun
 * @date 2025/4/23 23:06
 * @desciption: 31. 下一个排列
 */
public class LeetCode31 {
    public void nextPermutation(int[] nums) {
        int k = nums.length - 1;
        while (k >= 1 && nums[k - 1] >= nums[k]) {
            k--;
        }

        if (k == 0) {
            reverse(nums, 0, nums.length - 1);
        } else {
            int t = nums.length - 1;
            while (nums[t] <= nums[k - 1]) {
                t--;
            }
            swap(nums, k - 1, t);
            reverse(nums, k, nums.length - 1);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int left, int right) {
        while (left <= right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
