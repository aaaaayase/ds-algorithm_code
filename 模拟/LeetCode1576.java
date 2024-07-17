public class LeetCode1576 {
    public String modifyString(String ss) {
        char[] s = ss.toCharArray();
        int n = s.length;
        for (int i = 0; i < n; i++) {
            if (s[i] == '?') {
                for (int j = 'a'; j <= 'z'; j++) {
                    if ((i == 0 || s[i - 1] != j) && (i == n - 1 || s[i + 1] != j)) {
                        s[i] = (char) j;
                        break;
                    }
                }

            }
        }

        return new String(s);
    }
}
