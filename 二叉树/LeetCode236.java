import java.util.Stack;

public class LeetCode236 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        return lowestCommonAncestorChild2(root, p, q);
    }

    // public TreeNode lowestCommonAncestorChild1(TreeNode root, TreeNode p, TreeNode q) {
    //     if(root==null) {
    //         return null;
    //     }
    //     if(root==p || root==q) {
    //         return root;
    //     }

    //     TreeNode left=lowestCommonAncestor(root.left,p,q);
    //     TreeNode right=lowestCommonAncestor(root.right,p,q);
    //     if(left!=null && right!=null) {
    //         return root;
    //     } else if(right==null&&left!=null) {
    //         return left;
    //     } else if(right!=null&&left==null) {
    //         return right;
    //     }

    //     return null;
    // }

    public TreeNode lowestCommonAncestorChild2(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        getPath(root, p, stack1);
        getPath(root, q, stack2);

        int size1 = stack1.size();
        int size2 = stack2.size();

        int size = 0;
        if (size1 > size2) {
            size = size1 - size2;
            while (size != 0) {
                stack1.pop();
                size--;
            }
        }
        if (size1 < size2) {
            size = size2 - size1;
            while (size != 0) {
                stack2.pop();
                size--;
            }
        }

        while (stack1.peek() != stack2.peek()) {
            stack1.pop();
            stack2.pop();
        }

        return stack1.pop();
    }

    public boolean getPath(TreeNode root, TreeNode target, Stack<TreeNode> stack) {
        if (root == null) {
            return false;
        }
        stack.push(root);
        if (root == target) {
            return true;
        }

        boolean leftFlg = getPath(root.left, target, stack);
        if (leftFlg) {
            return true;
        }

        boolean rightFlg = getPath(root.right, target, stack);
        if (rightFlg) {
            return true;
        }
        stack.pop();
        return false;
    }

    
}
