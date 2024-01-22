package day10;

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(int val) {
        this.val=val;
    }
}
public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) {
            return true;
        }

        return isSymmetricChild(root.left,root.right);
    }

    public boolean isSymmetricChild(TreeNode leftTree,TreeNode rightTree) {
        if(leftTree==null&&rightTree==null) {
            return true;
        }

        if(leftTree==null&&rightTree!=null) {
            return false;
        }

        if(leftTree!=null&&rightTree==null) {
            return false;
        }

        if(leftTree.val!=rightTree.val) {
            return false;
        }


        return isSymmetricChild(leftTree.left,rightTree.right)&&isSymmetricChild(leftTree.right,rightTree.left);
    }
}
