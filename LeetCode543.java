/**
 * @author yun
 * @date 2025/2/23 10:01
 * @desciption: 543. 二叉树的直径
 */
public class LeetCode {
    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        depth(root);
        return ans - 1;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        ans = Math.max(ans, left + right + 1);
        return left > right ? left + 1 : right + 1;
    }
}
