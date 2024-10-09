public class LeetCode494 {
    int ret;
    int path;
    int target;

    public int findTargetSumWays(int[] nums, int _target) {

        target = _target;

        dfs(nums, 0);

        return ret;
    }

    public void dfs(int[] nums, int pos) {
        if (path == target && pos == nums.length) {
            ret++;
            return;
        } else if (pos == nums.length) {
            return;
        }

        int num = nums[pos];

        path -= num;
        dfs(nums, pos + 1);
        path += num;

        path += num;
        dfs(nums, pos + 1);
        path -= num;
    }
}
