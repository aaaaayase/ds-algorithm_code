import java.util.ArrayList;
import java.util.List;

public class LeetCode17 {

    List<String> ret = new ArrayList<>();
    StringBuilder path;
    String[] hash = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        ret = new ArrayList<>();
        path = new StringBuilder();

        if (digits.length() == 0) {
            return ret;
        }

        dfs(digits, 0);

        return ret;
    }

    public void dfs(String digits, int pos) {
        if (pos == digits.length()) {

            ret.add(path.toString());
            return;
        }

        String letters = hash[(int) (digits.charAt(pos) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));
            dfs(digits, pos + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }


}
