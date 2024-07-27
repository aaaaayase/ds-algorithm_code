public class LeetCode75 {

    public void sortColors(int[] nums) {
        int left = -1, right = nums.length;
        int i = 0;
        while (i < right) {
            if (nums[i] == 0) {
                swap(nums, ++left, i++);
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, --right, i);
            }
        }
    }

    public void swap(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }

}
