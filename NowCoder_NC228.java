public class NowCoder_NC228 {
    //给定两个字符串 S 和 T ，判断 S 是否是 T 的子序列。
    //即是否可以从 T 删除一些字符转换成 S。
    public boolean isSubsequence(String S, String T) {
        // write code here
        int j = 0;
        int i = 0;
        while (i < T.length()) {
            if (S.charAt(j) == T.charAt(i)) {
                j++;
            }
            i++;
        }
        if (j == S.length()) {
            return true;
        }
        return false;
    }
}
