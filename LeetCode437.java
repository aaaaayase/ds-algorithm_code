/**
 * @author yun
 * @date 2025/3/15 20:46
 * @desciption: 437. 路径总和 III
 */
public class LeetCode437 {
    int ret = 0;

    public int pathSum(TreeNode root, long targetSum) {
        if (root != null) {
            dfs(root, targetSum);
            pathSum(root.left, targetSum);
            pathSum(root.right, targetSum);
        }

        return ret;

    }

    public void dfs(TreeNode root, long sum) {
        if (root == null) {
            return;
        }

        if (root.val == sum) {
            ret++;
        }

        dfs(root.left, sum - root.val);
        dfs(root.right, sum - root.val);
    }
}
