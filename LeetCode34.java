public class LeetCode34 {
    //给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
    //
    //如果数组中不存在目标值 target，返回 [-1, -1]。
    //
    //你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
    public int[] searchRange(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        int mid = 0;
        boolean flg = false;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                flg = true;
                break;
            }
        }
        int adv = mid;
        int back = mid;
        while (adv < nums.length - 1 && nums[adv] == nums[adv + 1]) {
            adv++;
        }

        while (back > 0 && nums[back] == nums[back - 1]) {
            back--;
        }

        if (flg) {
            return new int[] { back, adv };
        }

        return new int[] { -1, -1 };
    }
}
