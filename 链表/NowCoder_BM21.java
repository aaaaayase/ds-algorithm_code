/**
 * @author yun
 * @date 2024/12/6 20:09
 * @desciption: 旋转数组的最小数字
 */
public class NowCoder_BM21 {
    public int minNumberInRotateArray (int[] nums) {
        // write code here
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right--;
            }
        }

        return nums[left];
    }
}
