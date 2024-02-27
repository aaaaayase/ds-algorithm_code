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
//给你二叉树的根节点 root ，请你采用前序遍历的方式，将二叉树转化为一个由括号和整数组成的字符串，返回构造出的字符串。
//
//空节点使用一对空括号对 "()" 表示，转化后需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
public class LeetCode606 {
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        tree2strChild(root, sb);
        return sb.toString();
    }

    public void tree2strChild(TreeNode root, StringBuilder sb) {

        if (root == null) {
            return;
        }
        sb.append(root.val);
        if (root.left != null) {
            sb.append("(");
            tree2strChild(root.left, sb);
            sb.append(")");
        } else {
            if (root.right == null) {
                return;
            } else {
                sb.append("()");
            }
        }

        if (root.right != null) {
            sb.append("(");
            tree2strChild(root.right, sb);
            sb.append(")");
        } else {
            return;
        }

    }
}
