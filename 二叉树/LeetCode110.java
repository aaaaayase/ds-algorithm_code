/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//给定一个二叉树，判断它是否是高度平衡的二叉树。
//
//本题中，一棵高度平衡二叉树定义为：
//
//一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
public class LeetCode110 {

    public boolean isBalanced(TreeNode root) {
        //return isBalancedChild1(root);
        return isBalancedChild2(root);

    }

    // public boolean isBalancedChild1(TreeNode root) {
    //     if(root==null) {
    //         return true;
    //     }
    //     int leftHeight=getHeight1(root.left);
    //     int rightHeight=getHeight1(root.right);
    //     if(Math.abs(leftHeight-rightHeight)<=1&&isBalancedChild1(root.left)&&isBalancedChild1(root.right)) {
    //         return true;
    //     }
    //     return false;
    // }

    // public int getHeight1(TreeNode root) {
    //     if(root==null) {
    //         return 0;
    //     }

    //     int leftHeight=getHeight1(root.left);
    //     int rightHeight=getHeight1(root.right);

    //     return (leftHeight>rightHeight?leftHeight:rightHeight)+1;

    // }

    public boolean isBalancedChild2(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (getHeight2(root) < 0) {
            return false;

        }
        return true;
    }

    public int getHeight2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight2(root.left);

        int rightHeight = getHeight2(root.right);

        if (leftHeight >= 0 && rightHeight >= 0 && Math.abs(leftHeight - rightHeight) <= 1) {
            return (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
        } else {
            return -1;
        }


    }


}
