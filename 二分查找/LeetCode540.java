public class LeetCode540 {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (right > left) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == nums[mid ^ 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[right];
    }
}
