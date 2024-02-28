import java.util.*;

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
//给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
public class LeetCode107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Stack<List<Integer>> stack=new Stack<>();
        List<List<Integer>> retList=new ArrayList<>();

        if(root==null) {
            return retList;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int size=0;

        while(!queue.isEmpty()) {
            size=queue.size();
            List<Integer> list=new ArrayList<>();
            while(size!=0) {
                TreeNode cur=queue.poll();
                if(cur.left!=null) {
                    queue.offer(cur.left);
                }

                if(cur.right!=null) {
                    queue.offer(cur.right);
                }
                list.add(cur.val);
                size--;
            }
            stack.push(list);
        }

        int stackSize=stack.size();
        for(int i=0;i<stackSize;i++) {
            retList.add(stack.pop());
        }

        return retList;
    }
}
