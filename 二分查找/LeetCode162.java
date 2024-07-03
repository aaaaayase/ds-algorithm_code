public class LeetCode162 {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (right > left) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > nums[mid - 1]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
