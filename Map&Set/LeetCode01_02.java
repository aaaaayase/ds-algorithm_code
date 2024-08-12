import java.util.HashMap;
import java.util.Map;

public class LeetCode01_02 {
    public boolean CheckPermutation(String ss1, String ss2) {
        Map<Character, Integer> map = new HashMap<>();
        char[] s1 = ss1.toCharArray();
        char[] s2 = ss2.toCharArray();

        for (int i = 0; i < s1.length; i++) {
            map.put(s1[i], map.getOrDefault(s1[i], 0) + 1);
        }

        for (int i = 0; i < s2.length; i++) {
            if (!map.containsKey(s2[i])) {
                return false;
            }
            map.put(s2[i], map.get(s2[i]) - 1);
            if (map.get(s2[i]) == 0) {
                map.remove(s2[i]);
            }
        }

        if (map.size() == 0) {
            return true;
        } else {
            return false;
        }

    }
}
