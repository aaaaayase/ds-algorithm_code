/**
 * @author yun
 * @date 2025/1/9 10:03
 * @desciption: 判断子序列
 */
public class LeetCode392 {
    public boolean isSubsequence(String _s, String _t) {
        char[] s = _s.toCharArray();
        char[] t = _t.toCharArray();
        int j = 0;
        int k = 0;
        while (k < s.length && j < t.length) {
            if (s[k] == t[j]) {
                k++;
            }
            j++;
        }
        if (k == s.length) {
            return true;
        }
        return false;

    }
}
