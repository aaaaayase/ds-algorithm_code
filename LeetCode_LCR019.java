/**
 * @author yun
 * @date 2025/2/6 13:33
 * @desciption: LCR 019. 验证回文串 II
 */
public class LeetCode_LCR019 {
    public boolean validPalindrome(String _s) {
        char[] s = _s.toCharArray();
        int right = s.length - 1;
        int left = 0;
        while (left <= right) {
            if (s[left] == s[right]) {
                left++;
                right--;
            } else {
                return support(s, right - 1, left) || support(s, right, left + 1);
            }
        }
        return true;
    }

    public boolean support(char[] s, int right, int left) {
        while (left <= right) {
            if (s[left] != s[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
