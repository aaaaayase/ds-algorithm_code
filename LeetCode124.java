/**
 * @author yun
 * @date 2025/3/16 23:09
 * @desciption: 124. 二叉树中的最大路径和
 */
public class LeetCode124 {
    int ret = Integer.MIN_VALUE;

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));

        // 这里两个都选是因为直接算的最大路径和
        ret = Math.max(ret, root.val + left + right);

        // 返回作为子树的最大路径和 因此左右子树只能选一个
        return Math.max(left, right) + root.val;

    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ret;
    }
}
