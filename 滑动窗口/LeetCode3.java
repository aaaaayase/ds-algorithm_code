public class LeetCode3 {
    public int lengthOfLongestSubstring(String ss) {
        int n = ss.length();
        char[] s = ss.toCharArray();
        int[] count = new int[128];
        int ret = 0;
        for (int right = 0, left = 0; right < n; right++) {
            count[s[right]]++;
            while (count[s[right]] > 1) {
                count[s[left]]--;
                left++;
            }
            ret = Math.max(ret, right - left + 1);
        }
        return ret;
    }
}
