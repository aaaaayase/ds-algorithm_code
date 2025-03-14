import javax.swing.tree.TreeNode;

/**
 * @author yun
 * @date 2025/3/14 22:52
 * @desciption: 114. 二叉树展开为链表
 */
public class LeetCode114 {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode temp = cur.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                temp.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
}
