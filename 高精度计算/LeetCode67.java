public class LeetCode67 {
    public String addBinary(String a, String b) {

        int cur1 = a.length() - 1;
        int cur2 = b.length() - 1;

        int t = 0;
        StringBuilder ret = new StringBuilder();
        while (cur1 >= 0 || cur2 >= 0 || t > 0) {
            if (cur1 >= 0) {
                t += a.charAt(cur1) - '0';
                cur1--;
            }
            if (cur2 >= 0) {
                t += b.charAt(cur2) - '0';
                cur2--;
            }

            ret.append(t % 2);
            t /= 2;

        }

        return ret.reverse().toString();

    }
}
