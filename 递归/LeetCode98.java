public class LeetCode98 {
    long preNum = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean left = isValidBST(root.left);
        if (left == false) {
            return false;
        }

        boolean cur = false;

        if (preNum < root.val) {
            cur = true;
        }

        if (cur == false) {
            return false;
        }

        preNum = root.val;
        boolean right = isValidBST(root.right);
        return right && left && cur;
    }
}
