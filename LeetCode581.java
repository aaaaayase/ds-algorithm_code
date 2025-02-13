/**
 * @author yun
 * @date 2025/2/13 23:34
 * @desciption: 581. 最短无序连续子数组
 */
public class LeetCode581 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] temp = Arrays.copyOf(nums, n);
        Arrays.sort(nums);

        int start = -1;
        int end = -1;
        if (nums[0] == temp[0] && nums[n - 1] == temp[n - 1]) {
            for (int i = n - 1; i >= 0; i--) {
                if (temp[i] != nums[i]) {
                    end = i;
                    break;
                }
            }
            for (int i = 0; i <= n - 1; i++) {
                if (temp[i] != nums[i]) {
                    start = i;
                    break;
                }
            }
            if (end == -1 && start == -1) {
                return 0;
            }
            return end - start + 1;
        } else if (nums[0] == temp[0] && nums[n - 1] != temp[n - 1]) {
            for (int i = 0; i <= n - 1; i++) {
                if (temp[i] != nums[i]) {
                    start = i;
                    break;
                }
            }
            return n - start;
        } else if (nums[0] != temp[0] && nums[n - 1] == temp[n - 1]) {
            for (int i = n - 1; i >= 0; i--) {
                if (temp[i] != nums[i]) {
                    end = i;
                    break;
                }
            }
            return end + 1;
        } else if (nums[0] != temp[0] && nums[n - 1] != temp[n - 1]) {
            return n;
        }
        return end - start;
    }
}
