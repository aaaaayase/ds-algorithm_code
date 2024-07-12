import java.util.HashMap;
import java.util.Map;

public class LeetCode974 {
    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0, ret = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0 % k, 1);
        for (int x : nums) {
            sum += x;
            int temp = (sum % k + k) % k;
            ret += map.getOrDefault(temp, 0);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }

        return ret;
    }
}
