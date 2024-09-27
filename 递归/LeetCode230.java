public class LeetCode230 {
    int count = 0;
    int ret=0;

    public int kthSmallest(TreeNode root, int k) {
        count=k;
        dfs(root);
        return ret;
    }

    public void dfs(TreeNode root) {
        if(root==null || count==0) {
            return ;
        }

        dfs(root.left);
        count--;
        if(count==0) {
            ret=root.val;
            return ;
        }
        dfs(root.right);

    }
}
