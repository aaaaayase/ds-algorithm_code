/**
 * @author yun
 * @date 2024/12/28 11:49
 * @desciption: 验证回文串
 */
public class Solution1 {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (right > left) {
            while (right > left &&!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            while (right > left &&!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            if (Character.toLowerCase(s.charAt(right)) != Character.toLowerCase(s.charAt(left))) {

                return false;
            }
            right--;
            left++;
        }

        return true;
    }
}
