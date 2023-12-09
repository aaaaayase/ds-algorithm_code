package day7;

public class demo3 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
            this.val = val;
        }

    }

    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        if (root.right == null && root.left == null) {
            return root;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
