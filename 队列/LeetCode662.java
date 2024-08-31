import java.util.ArrayList;

public class LeetCode662 {
    public int widthOfBinaryTree(TreeNode root) {
        List<Pair<TreeNode, Integer>> q = new ArrayList<>();
        q.add(new Pair<TreeNode, Integer>(root, 1));
        int ret = 0;
        while (!q.isEmpty()) {
            int x1 = q.get(0).getValue();
            int x2 = q.get(q.size() - 1).getValue();
            ret = Math.max(x2 - x1 + 1, ret);

            List<Pair<TreeNode, Integer>> temp = new ArrayList<>();
            for (Pair<TreeNode, Integer> p : q) {
                if (p.getKey().left != null) {
                    temp.add(new Pair<TreeNode, Integer>(p.getKey().left, p.getValue() * 2));
                }

                if (p.getKey().right != null) {
                    temp.add(new Pair<TreeNode, Integer>(p.getKey().right, p.getValue() * 2 + 1));
                }
            }
            q = temp;
        }

        return ret;
    }
}
