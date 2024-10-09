import java.util.ArrayList;
import java.util.List;

public class LeetCode77 {
    List<List<Integer>> ret;
    List<Integer> path;
    int len;
    int num;

    public List<List<Integer>> combine(int n, int k) {

        ret = new ArrayList<>();
        path = new ArrayList<>();
        len = k;
        num = n;

        dfs(1);

        return ret;
    }

    public void dfs(int pos) {

        if (len == path.size()) {
            ret.add(new ArrayList<>(path));
            return;
        }

        for (int i = pos; i <= num; i++) {
            path.add(i);
            dfs(i + 1);
            path.remove(path.size() - 1);
        }

    }
}
