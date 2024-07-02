public class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {
        int left1 = 0, right1 = nums.length - 1;
        if (right1 == -1) {
            return new int[] { -1, -1 };
        }
        int[] ret = new int[2];
        while (left1 < right1) {
            int mid1 = left1 + (right1 - left1) / 2;
            if (nums[mid1] < target) {
                left1 = mid1 + 1;
            } else {
                right1 = mid1;
            }
        }

        if (nums[right1] == target) {
            ret[0] = right1;
        } else {
            ret[0] = -1;
        }

        int left2 = 0, right2 = nums.length - 1;

        while (left2 < right2) {
            int mid2 = left2 + (right2 - left2 + 1) / 2;
            if (nums[mid2] > target) {
                right2 = mid2 - 1;
            } else {
                left2 = mid2;
            }
        }

        if (nums[left2] == target) {
            ret[1] = left2;
        } else {
            ret[1] = -1;
        }

        return ret;
    }
}
