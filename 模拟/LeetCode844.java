public class LeetCode844 {
    public String process(String str) {

        StringBuilder ret = new StringBuilder();

        char[] s = str.toCharArray();

        for (char ch : s) {
            if (ch == '#') {
                if (ret.length() > 0) {
                    ret.deleteCharAt(ret.length() - 1);
                }
            } else {
                ret.append(ch);
            }

        }

        return ret.toString();

    }

    public boolean backspaceCompare(String s, String t) {

        return process(s).equals(process(t));

    }
}
