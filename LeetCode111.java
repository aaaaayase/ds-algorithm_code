public class LeetCode111 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public int count = 0;

        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }


            int leftH = minDepth(root.left);
            int rightH = minDepth(root.right);
            if (root.left == null || root.right == null) {
                return leftH + rightH + 1;
            }
            return leftH < rightH ? leftH + 1 : rightH + 1;
        }
    }
}
