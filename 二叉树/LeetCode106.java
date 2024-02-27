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
//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
public class LeetCode106 {
    public int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex=postorder.length-1;
        return buildTreeChild(inorder,postorder,0,inorder.length-1);
    }

    public TreeNode buildTreeChild(int[] inorder, int[] postorder,int begin,int end) {
        if(begin>end) {
            return null;
        }

        TreeNode root=new TreeNode(postorder[postIndex]);
        int rootIndex=getRootIndex(inorder,postorder[postIndex]);
        postIndex--;
        root.right=buildTreeChild(inorder,postorder,rootIndex+1,end);
        root.left=buildTreeChild(inorder,postorder,begin,rootIndex-1);
        return root;
    }

    public int getRootIndex(int[] inorder, int target) {
        for(int i=0;i<inorder.length;i++) {
            if(inorder[i]==target) {
                return i;
            }
        }
        return -1;
    }
}
