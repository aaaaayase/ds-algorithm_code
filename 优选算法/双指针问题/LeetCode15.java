import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> retList = new ArrayList<>();

        for (int i = n - 1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;
            while (right > left) {
                int sum = nums[left] + nums[right];
                if (sum > -nums[i]) {
                    right--;
                } else if (sum < -nums[i]) {
                    left++;
                } else {
                    retList.add(new ArrayList(Arrays.asList(nums[left], nums[right], nums[i])));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (right > left && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
            while (i > 1 && nums[i] == nums[i-1]) {
                i--;
            }
        }
        return retList;
    }
}
