public class LeetCode572 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
            this.val = val;
        }

    }

    //给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。
    // 如果存在，返回 true ；
    // 否则，返回 false 。
    //二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        if (isSameTree(root,subRoot)) {
            return true;
        }

        if (isSubtree(root.left,subRoot)) {
            return true;
        }

        if (isSubtree(root.right,subRoot)) {
            return true;
        }

        return false;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p != null && q == null || p == null && q != null || p.val != q.val) {
            return false;
        }


        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);


    }
}
