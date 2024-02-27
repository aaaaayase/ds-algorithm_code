import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode102 {
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
    //给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> retList=new ArrayList();

            if(root==null) {
                return retList;
            }
            Queue<TreeNode> queue=new LinkedList();
            queue.offer(root);
            int size=0;
            while(!queue.isEmpty()) {
                List<Integer> list=new ArrayList();
                size=queue.size();
                while((size--)!=0) {
                    TreeNode cur=queue.poll();
                    list.add(cur.val);
                    if(cur.left!=null) {
                        queue.offer(cur.left);
                    }
                    if(cur.right!=null) {
                        queue.offer(cur.right);
                    }
                }


                retList.add(list);
            }
            return retList;
        }
    }
}
