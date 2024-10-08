import java.util.ArrayList;
import java.util.List;

public class LeetCode1863 {
    List<List<Integer>> ret;
    List<Integer> path;

    public int subsetXORSum(int[] nums) {
        ret = new ArrayList<>();
        path = new ArrayList<>();
        int sum = 0;
        dfs(nums, 0);

        for (List<Integer> list : ret) {
            if (list.size() == 0) {
                continue;
            } else if (list.size() == 1) {
                sum += list.get(0);
            } else {
                int temp = list.get(0);
                for (int i = 1; i < list.size(); i++) {
                    temp ^= list.get(i);
                }
                sum += temp;
            }
        }

        return sum;
    }

    public void dfs(int[] nums, int pos) {
        if (pos == nums.length) {
            ret.add(new ArrayList<>(path));
            return;
        }

        dfs(nums, pos + 1);
        path.add(nums[pos]);
        dfs(nums, pos + 1);
        path.remove(path.size() - 1);
    }


}
