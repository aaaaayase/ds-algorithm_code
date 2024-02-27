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
//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点
public class LeetCode105 {
    public int preIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeChild(preorder,inorder,0,inorder.length-1);
    }

    public TreeNode buildTreeChild(int[] preorder,int[] inorder,int begin,int end) {
        if(end<begin) {
            return null;
        }
        TreeNode root=new TreeNode(preorder[preIndex]);
        int index=getIndex(inorder,preorder[preIndex],begin,end);
        preIndex++;
        root.left=buildTreeChild(preorder,inorder,begin,index-1);
        root.right=buildTreeChild(preorder,inorder,index+1,end);
        return root;
    }

    public int getIndex(int[] arr,int target,int begin,int end) {
        for(int i=begin;i<=end;i++) {
            if(target==arr[i]) {
                return i;
            }
        }

        return -1;
    }
}
