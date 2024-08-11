import java.util.HashMap;
import java.util.Map;

public class LeetCode1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (hash.containsKey(temp)) {
                return new int[] { i, hash.get(temp) };
            }
            hash.put(nums[i], i);
        }
        return null;
    }
}
