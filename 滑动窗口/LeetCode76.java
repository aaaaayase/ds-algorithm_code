import java.util.HashMap;
import java.util.Map;

public class LeetCode76 {
    public String minWindow(String ss, String tt) {
        Map<Character, Integer> hash1 = new HashMap<>();
        Map<Character, Integer> hash2 = new HashMap<>();

        char[] s = ss.toCharArray();
        char[] t = tt.toCharArray();

        for (char ch : t) {
            hash1.put(ch, hash1.getOrDefault(ch, 0) + 1);
        }

        int n = ss.length();
        int aim = hash1.size();
        int minL = Integer.MAX_VALUE;
        int begin = -1;

        for (int left = 0, right = 0, count = 0; right < n; right++) {
            char in = s[right];
            hash2.put(in, hash2.getOrDefault(in, 0) + 1);

            if (hash1.containsKey(in) && hash1.get(in).equals(hash2.get(in))) {
                count++;
            }

            while (count == aim) {
                if ((right - left + 1) < minL) {
                    minL = right - left + 1;
                    begin = left;
                }
                char out = s[left];
                hash2.put(out, hash2.get(out) - 1);
                if (hash1.containsKey(out) && hash2.get(out) < hash1.get(out)) {
                    count--;
                }
                left++;
            }
        }

        return begin == -1 ? "" : ss.substring(begin, begin + minL);
    }
}
