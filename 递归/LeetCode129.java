public class LeetCode129 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int preSum) {
        if (root == null) {
            return 0;
        }
        preSum = preSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return preSum;
        }

        int left = dfs(root.left, preSum);
        int right = dfs(root.right, preSum);

        return left + right;
    }
}
