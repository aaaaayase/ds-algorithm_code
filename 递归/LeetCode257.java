import java.util.ArrayList;
import java.util.List;

public class LeetCode257 {

    List<String> ret;

    public List<String> binaryTreePaths(TreeNode root) {
        ret = new ArrayList<>();
        dfs(root, new StringBuilder());
        return ret;
    }

    public void dfs(TreeNode root, StringBuilder _path) {
        StringBuilder path = new StringBuilder(_path);
        path.append(Integer.toString(root.val));
        if (root.left == null && root.right == null) {
            ret.add(path.toString());
            return;
        }

        path.append("->");
        if (root.left != null) {
            dfs(root.left, path);
        }

        if (root.right != null) {
            dfs(root.right, path);
        }

    }

}
