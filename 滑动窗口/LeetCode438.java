import java.util.ArrayList;
import java.util.List;

public class LeetCode438 {
    public List<Integer> findAnagrams(String ss, String p) {
        List<Integer> ret = new ArrayList<>();
        int[] arrP = new int[26];
        int[] arrS = new int[26];
        char[] s = ss.toCharArray();
        int count = 0;
        int aim = 0;
        for (char ch : p.toCharArray()) {
            arrP[ch - 'a']++;
            aim++;
        }
        int n = ss.length();
        int m = p.length();
        for (int left = 0, right = 0; right < n; right++) {
            arrS[s[right] - 'a']++;
            if (arrS[s[right] - 'a'] <= arrP[s[right] - 'a']) {
                count++;
            }
            while (right - left + 1 > m) {
                arrS[s[left] - 'a']--;
                if (arrS[s[left] - 'a'] < arrP[s[left] - 'a']) {
                    count--;
                }
                left++;
            }
            if (count == aim) {
                ret.add(left);
            }
        }
        return ret;
    }
}
