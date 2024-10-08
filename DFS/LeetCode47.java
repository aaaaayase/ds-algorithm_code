import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode47 {

    List<List<Integer>> ret;
    List<Integer> path;
    boolean[] check;

    public List<List<Integer>> permuteUnique(int[] nums) {
        ret = new ArrayList<>();
        path = new ArrayList<>();
        check = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums);

        return ret;

    }

    public void dfs(int[] nums) {
        if (path.size() == nums.length) {
            ret.add(new ArrayList<>(path));
            return;
        }

        // 只关心正确的情况
        for (int i = 0; i < nums.length; i++) {
            if (check[i] == false && (i == 0 || nums[i] != nums[i - 1] || check[i - 1] == true)) {
                path.add(nums[i]);
                check[i] = true;
                dfs(nums);
                check[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }


}
