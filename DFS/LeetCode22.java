import java.util.ArrayList;
import java.util.List;

public class LeetCode22 {
    List<String> ret;
    StringBuilder path;
    int len;
    int left;
    int right;

    public List<String> generateParenthesis(int n) {
        ret = new ArrayList<>();
        path = new StringBuilder();
        len = n;

        dfs();

        return ret;
    }

    public void dfs() {

        if (2 * len == path.length()) {
            ret.add(path.toString());
            return;
        }

        if (left < len) {
            path.append('(');
            left++;
            dfs();
            left--;
            path.deleteCharAt(path.length() - 1);
        }

        if (right < left) {
            path.append(')');
            right++;
            dfs();
            right--;
            path.deleteCharAt(path.length() - 1);
        }
    }
}
