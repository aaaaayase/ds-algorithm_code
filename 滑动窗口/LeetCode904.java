import java.util.HashMap;
import java.util.Map;

public class LeetCode904 {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int ret = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int left = 0, right = 0; right < n; right++) {
            int in = fruits[right];
            map.put(in, map.getOrDefault(in, 0) + 1);
            while (map.size() > 2) {
                int out = fruits[left];
                map.put(out, map.get(out) - 1);
                if (map.get(out) == 0) {
                    map.remove(out);
                }
                left++;
            }
            ret = Math.max(ret, right - left + 1);
        }
        return ret;
    }
}
