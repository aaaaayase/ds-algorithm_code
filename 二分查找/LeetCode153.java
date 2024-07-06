public class LeetCode153 {
    public int findMin(int[] nums) {
        int n = nums.length - 1;
        int left = 0, right = n;
        while (right > left) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[n]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[right];
    }
}
