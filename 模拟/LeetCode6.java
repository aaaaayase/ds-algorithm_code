public class LeetCode6 {
    public String convert(String ss, int numRows) {
        if (numRows == 1) {
            return ss;
        }
        int n = ss.length();
        char[] s = ss.toCharArray();
        StringBuilder ret = new StringBuilder();
        int d = 2 * numRows - 2;
        for (int i = 0; i < n; i += d) {
            ret.append(s[i]);
        }
        for (int i = 1; i < numRows - 1; i++) {
            for (int j = i, k = d - j; k < n || j < n; k += d, j += d) {
                if (j < n) {
                    ret.append(s[j]);
                }

                if (k < n) {
                    ret.append(s[k]);
                }
            }
        }
        for (int i = numRows - 1; i < n; i += d) {
            ret.append(s[i]);
        }
        return ret.toString();
    }
}
