import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode30 {
    public List<Integer> findSubstring(String s, String[] words) {
        int len = words[0].length();
        int aim = words.length;
        List<Integer> list = new ArrayList<>();
        HashMap<String, Integer> hash = new HashMap<>();
        for (String str : words) {
            hash.put(str, hash.getOrDefault(str, 0) + 1);
        }
        int n = s.length();
        for (int i = 0; i < len; i++) {
            HashMap<String, Integer> temp = new HashMap<>();
            for (int left = i, right = i, count = 0; right + len <= n; right += len) {
                String in = s.substring(right, right + len);
                temp.put(in, temp.getOrDefault(in, 0) + 1);
                if (hash.getOrDefault(in, 0) != 0 && temp.get(in) <= hash.get(in)) {
                    count++;
                }
                while (right - left + 1 > aim * len) {
                    String out = s.substring(left, left + len);
                    temp.put(out, temp.get(out) - 1);
                    if (hash.getOrDefault(out, 0) != 0 && temp.get(out) < hash.get(out)) {
                        count--;
                    }
                    left += len;
                }
                if (count == aim) {
                    list.add(left);
                }
            }
        }

        return list;
    }
}
