public class LeetCode01_01 {
    public boolean isUnique(String astr) {
        if (astr.length() > 26) {
            return false;
        }

        int bitMap = 0;
        for (char ch : astr.toCharArray()) {
            int temp = ch - '0';
            if (((bitMap >> temp) & 1) == 1) {
                return false;
            } else {
                bitMap |= (1 << temp);
            }
        }
        return true;
    }
}
