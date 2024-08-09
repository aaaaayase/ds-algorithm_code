public class LeetCode2331 {
    public boolean evaluateTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (root.val == 0 && root.left == null && root.right == null) {
            return false;
        }
        if (root.val == 1 && root.left == null && root.right == null) {
            return true;
        }

        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);

        if (root.val == 2) {
            return left || right;
        } else {
            return left && right;
        }
    }
}
