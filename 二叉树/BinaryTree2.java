public class BinaryTree2 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
            this.val = val;
        }

    }

    private int nodeSize;

    //节点数 遍历
    public void size(TreeNode root) {
        if (root == null) {
            return;
        }
        nodeSize++;
        size(root.left);
        size(root.right);
    }

    //子问题
    public int size2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + size2(root.left) + size2(root.right);
    }

    private int leafSize;

    //叶子节点数 遍历
    public void getLeafNodeCount(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.right == null && root.left == null) {
            leafSize++;
        }

        getLeafNodeCount(root.left);
        getLeafNodeCount(root.right);
    }

    //子问题
    public int getLeafNodeCount2(TreeNode root) {

        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafNodeCount2(root.left) + getLeafNodeCount2(root.right);
    }

    //root的第k层有多少个节点
    public int getKLevelNodeCount(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        k--;

        return getKLevelNodeCount(root.left, k) + getKLevelNodeCount(root.right, k);

    }

    //树的高度
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }


    //在树中找到值尾val的节点并返回
    public TreeNode find(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }

        TreeNode leftVal = find(root.left, val);
        if (leftVal != null) {
            return leftVal;
        }
        TreeNode rightVal = find(root.right, val);
        if (rightVal != null) {
            return rightVal;
        }

        return null;
    }
}
