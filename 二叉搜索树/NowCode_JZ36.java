import java.util.ArrayList;
import java.util.List;

public class NowCode_JZ36 {
    //输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
    public List<TreeNode> list = new ArrayList<>();
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        inorder(pRootOfTree);

        TreeNode head = list.remove(0);
        TreeNode retNode = head;
        for (TreeNode node :
                list) {
            head.right = node;
            node.left = head;
            head = node;
        }

        return retNode;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return ;
        }

        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }
}
