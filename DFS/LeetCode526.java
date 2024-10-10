public class LeetCode526 {
    int ret;
    boolean[] checked;

    public int countArrangement(int n) {

        checked = new boolean[n + 1];
        dfs(1, n);

        return ret;
    }

    public void dfs(int pos, int n) {

        if (pos == n + 1) {
            ret++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!checked[i] && (i % pos == 0 || pos % i == 0)) {
                checked[i] = true;
                dfs(pos + 1, n);
                checked[i] = false;
            }
        }

    }
}
