/**
 * @author yun
 * @date 2025/2/9 13:51
 * @desciption: 56. 合并区间
 */
public class LeetCode56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> temp = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int l = intervals[i][0], r = intervals[i][1];
            if (temp.size() == 0 || temp.get(temp.size() - 1)[1] < l) {
                temp.add(new int[] { l, r });
            } else {
                temp.get(temp.size() - 1)[1] = Math.max(r, temp.get(temp.size() - 1)[1]);
            }
        }
        return temp.toArray(new int[temp.size()][]);
    }
}
