/**
 * @author yun
 * @date 2025/3/18 11:50
 * @desciption: 131. 分割回文串
 */
public class LeetCode131 {
    List<List<String>> ret;
    List<String> path;

    public boolean isP(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(right) == s.charAt(left)) {
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;
    }

    public List<List<String>> partition(String s) {
        ret = new ArrayList<>();
        path = new ArrayList<>();
        dfs(s, 0);
        return ret;
    }

    public void dfs(String s, int start) {
        if (start >= s.length()) {
            ret.add(new ArrayList<>(path));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            String temp = s.substring(start, end + 1);
            if (isP(temp)) {
                path.add(temp);
                dfs(s, end + 1);
                if (path.size() != 0) {
                    path.remove(path.size() - 1);
                }

            }

        }
    }
}
