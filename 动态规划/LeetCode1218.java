import java.util.HashMap;
import java.util.Map;

public class LeetCode1218 {

    //给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
    //
    //子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> hash = new HashMap<>();

        int ret = 1;
        for (int a :
                arr) {

            hash.put(a, hash.getOrDefault(a - difference, 0) + 1);
            ret = Math.max(ret, hash.get(a));

        }

        return ret;
    }

}
