public class BinaryTree1 {

    static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    //后序遍历
    public void postOrder(TreeNode root) {

        if (root==null) {
            return ;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");

    }

    //中序遍历
    public void inOrder(TreeNode root) {

        if (root==null) {
            return ;
        }

        postOrder(root.left);
        System.out.print(root.val+" ");
        postOrder(root.right);


    }

    //先序遍历
    public void preOrder(TreeNode root) {

        if (root==null) {
            return ;
        }

        System.out.print(root.val+" ");
        postOrder(root.left);
        postOrder(root.right);


    }
}




