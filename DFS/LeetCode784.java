import java.util.ArrayList;
import java.util.List;

public class LeetCode784 {
    List<String> ret;
    StringBuilder path;

    public List<String> letterCasePermutation(String s) {

        ret = new ArrayList<>();
        path = new StringBuilder();

        dfs(s, 0);

        return ret;

    }

    public void dfs(String s, int pos) {
        if (s.length() == path.length()) {
            ret.add(path.toString());
            return;
        }

        char ch = s.charAt(pos);
        if (ch <= '9' && ch >= '0') {
            path.append(ch);
            dfs(s, pos + 1);
            path.deleteCharAt(path.length() - 1);
        } else {
            if (ch >= 'a' && ch <= 'z') {
                path.append((char) (ch - 32));
                dfs(s, pos + 1);
                path.deleteCharAt(path.length() - 1);

                path.append(ch);
                dfs(s, pos + 1);
                path.deleteCharAt(path.length() - 1);
            } else {
                path.append((char) (ch + 32));
                dfs(s, pos + 1);
                path.deleteCharAt(path.length() - 1);

                path.append(ch);
                dfs(s, pos + 1);
                path.deleteCharAt(path.length() - 1);
            }

        }

    }
}
