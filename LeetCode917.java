/**
 * @author yun
 * @date 2025/1/26 12:20
 * @desciption: 仅仅反转字母
 */
public class LeetCode917 {
    public String reverseOnlyLetters(String _s) {
        int left=0;
        int right=_s.length()-1;
        char[] s=_s.toCharArray();
        while(left<right) {
            while(left<right&&!Character.isLetter(s[left])) {
                left++;
            }
            while(left<right&&!Character.isLetter(s[right])) {
                right--;
            }
            char temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }

        return new String(s);
    }
}
