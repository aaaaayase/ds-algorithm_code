import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode39 {
    List<List<Integer>> ret;
    List<Integer> path;
    int pathSum;
    int target;

    public List<List<Integer>> combinationSum(int[] candidates, int _target) {

        ret = new ArrayList<>();
        path = new ArrayList<>();
        target = _target;
        Arrays.sort(candidates);

        dfs(candidates, 0);

        return ret;

    }

    public void dfs(int[] nums, int pos) {
        if (pathSum > target) {
            return;
        }

        if (pathSum == target) {
            ret.add(new ArrayList<>(path));
            return;
        }

        for (int i = pos; i < nums.length; i++) {
            pathSum += nums[i];
            path.add(nums[i]);
            dfs(nums, i);
            pathSum -= nums[i];
            path.remove(path.size() - 1);
        }
    }
}
