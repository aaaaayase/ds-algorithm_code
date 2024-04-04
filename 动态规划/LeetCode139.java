import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode139 {

    //给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
    //
    //注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);

        int n = s.length();

        boolean[] dp = new boolean[n + 1];

        dp[0] = true;

        s = " " + s;

        for (int i = 1; i <= n; i++) {
            for (int j = i; j >= 1; j--) {
                if (dp[j - 1] && set.contains(s.substring(j, i + 1))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }


}
