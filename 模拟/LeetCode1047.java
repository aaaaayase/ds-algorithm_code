public class LeetCode1047 {
    public String removeDuplicates(String str) {
        char[] s = str.toCharArray();
        StringBuilder ret = new StringBuilder();

        for (char ch : s) {
            if (ret.length() > 0 && ret.charAt(ret.length() - 1) == ch) {
                ret.deleteCharAt(ret.length() - 1);
            } else {
                ret.append(ch);
            }
        }

        return ret.toString();
    }
}
