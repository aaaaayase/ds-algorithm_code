import java.util.ArrayList;
import java.util.List;

public class LeetCode78 {
    List<List<Integer>> ret;
    List<Integer> path;

    public List<List<Integer>> subsets(int[] nums) {
        ret = new ArrayList<>();
        path = new ArrayList<>();

        dfs(nums, 0);

        return ret;
    }

    public void dfs(int[] nums, int i) {

        if (nums.length == i) {
            ret.add(new ArrayList<>(path));
            return;
        }

        dfs(nums, i + 1);
        path.add(nums[i]);
        dfs(nums, i + 1);
        path.remove(path.size() - 1);

    }
}
