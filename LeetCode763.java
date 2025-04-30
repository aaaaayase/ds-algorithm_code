/**
 * @author yun
 * @date 2025/4/29 22:51
 * @desciption:
 */
public class LeetCode763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ret = new ArrayList<>();
        int[] count = new int[26];
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            count[chs[i] - 'a'] = i;
        }
        int start = 0, end = 0;
        for (int i = 0; i < chs.length; i++) {
            end = Math.max(count[chs[i]-'a'], end);
            if (end == i) {
                ret.add(end - start + 1);
                start = end + 1;
            }
        }
        return ret;
    }

}
