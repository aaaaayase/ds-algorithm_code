import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ret = new ArrayList<>();

        if (root == null) {
            return ret;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            while (size-- != 0) {
                TreeNode node = q.poll();
                max = Math.max(max, node.val);
                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }
            ret.add(max);
            max = Integer.MIN_VALUE;

        }
        return ret;
    }
}
