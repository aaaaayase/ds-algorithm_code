import java.util.ArrayList;
import java.util.List;

public class LeetCode46 {
    List<List<Integer>> ret;
    int n = 0;
    List<Integer> path;
    boolean[] check;

    public List<List<Integer>> permute(int[] nums) {

        n = nums.length;
        ret = new ArrayList<>();
        path = new ArrayList<>();
        check = new boolean[n];

        dfs(nums);
        return ret;

    }

    public void dfs(int[] nums) {
        if (n == path.size()) {
            ret.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (check[i] == false) {
                path.add(nums[i]);
                check[i] = true;
                dfs(nums);
                check[i] = false;
                path.remove(path.size() - 1);
            }

        }
    }
}
