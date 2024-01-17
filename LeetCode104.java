
public class LeetCode104 {
    private static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public int maxDepth(TreeNode root) {
        if(root==null) {
            return 0;
        }

        int left=maxDepth(root.left);
        int right=maxDepth(root.right);

        return left>=right? left+1:right+1;
    }
}
