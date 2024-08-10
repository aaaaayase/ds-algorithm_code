public class LeetCode129 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int preSum) {
        preSum = preSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return preSum;
        }

        int ret = 0;
        if (root.left != null) {
            ret += dfs(root.left, preSum);
        }
        if (root.right != null) {
            ret += dfs(root.right, preSum);
        }

        return ret;
    }
}
