import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = n - 1; i > 2;) {
            for (int j = i - 1; j > 1;) {
                int left = 0;
                int right = j - 1;
                long aim = (long) target - nums[i] - nums[j];
                while (left < right) {
                    int temp = nums[left] + nums[right];
                    if (temp > aim) {
                        right--;
                    } else if (temp < aim) {
                        left++;
                    } else {
                        list.add(new ArrayList(Arrays.asList(nums[left], nums[right], nums[j], nums[i])));
                        left++;
                        right--;
                        while (left < right && nums[left - 1] == nums[left]) {
                            left++;
                        }
                        while (left < right & nums[right + 1] == nums[right]) {
                            right--;
                        }
                    }
                }
                j--;
                while (j > 1 && nums[j + 1] == nums[j]) {
                    j--;
                }
            }
            i--;
            while (i > 2 && nums[i + 1] == nums[i]) {
                i--;
            }
        }
        return list;
    }
}
