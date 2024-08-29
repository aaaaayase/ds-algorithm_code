import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int index = 1;
        while (q.size() != 0) {
            int sz = q.size();
            List<Integer> temp = new ArrayList<>();
            while (sz-- != 0) {
                TreeNode node = q.poll();
                int value = node.val;
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }

                if (index % 2 == 1) {
                    temp.add(value);
                } else {
                    temp.add(0, value);
                }
            }
            ret.add(temp);
            index++;
        }

        return ret;
    }
}
