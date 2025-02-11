/**
 * @author yun
 * @date 2025/2/11 23:18
 * @desciption: 932. 漂亮数组
 */
public class LeetCode932 {
    Map<Integer, int[]> map = new HashMap<>();

    public int[] beautifulArray(int n) {
        return f(n);
    }

    public int[] f(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int[] ans = new int[n];
        if (n == 1) {
            ans[0] = 1;
        } else {
            int k = 0;
            for (int i : f((n + 1) / 2)) {
                ans[k++] = 2 * i - 1;
            }

            for (int i : f(n / 2)) {
                ans[k++] = 2 * i;
            }
        }
        map.put(n, ans);
        return ans;
    }
}
