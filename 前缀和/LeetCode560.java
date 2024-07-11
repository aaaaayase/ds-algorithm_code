import java.util.HashMap;
import java.util.Map;

public class LeetCode560 {
    public int subarraySum(int[] nums, int k) {
        int ret = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int x : nums) {
            sum += x;
            ret += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ret;
    }
}
