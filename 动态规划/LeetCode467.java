public class LeetCode467 {
    //定义字符串 base 为一个 "abcdefghijklmnopqrstuvwxyz" 无限环绕的字符串，所以 base 看起来是这样的：
    //
    //"...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
    //给你一个字符串 s ，请你统计并返回 s 中有多少 不同非空子串 也在 base 中出现。
    public int findSubstringInWraproundString(String s) {
        int n = s.length();

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            if (((s.charAt(i) - s.charAt(i - 1)) == 1) || (s.charAt(i) == 'a' && s.charAt(i - 1) == 'z')) {
                dp[i] += dp[i - 1];
            }
        }

        int[] ret = new int[26];
        for (int i = 0; i < n; i++) {
            ret[s.charAt(i) - 'a'] = Math.max(ret[s.charAt(i) - 'a'], dp[i]);
        }

        int sum = 0;
        for (int x : ret) {
            sum += x;
        }
        return sum;
    }
}
