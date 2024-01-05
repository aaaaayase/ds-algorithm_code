import java.util.HashSet;
import java.util.Set;

public class LeetCode3 {

    //给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

    public int lengthOfLongestSubstring(String s) {
        Set<Character> occ = new HashSet<Character>();
        int ans = 0, rs = 0;

        int len = s.length();

        for (int i = 0; i < len; i++) {
            if (i != 0) {
                occ.remove(s.charAt(i - 1));
            }

            while (rs < len && !occ.contains(s.charAt(rs))) {
                occ.add(s.charAt(rs));
                rs++;
            }

            ans = Math.max(ans,rs-i);
        }

        return ans;
    }

}
