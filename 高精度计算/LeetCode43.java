public class LeetCode43 {
    public String multiply(String s, String ss) {
        // 1、准备工作
        int m = s.length(), n = ss.length();
        char[] num1 = new StringBuilder(s).reverse().toString().toCharArray();
        char[] num2 = new StringBuilder(ss).reverse().toString().toCharArray();
        int[] temp = new int[m + n - 1];

        // 2、无进位相乘
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i + j] += (num1[i] - '0') * (num2[j] - '0');
            }
        }

        // 3、处理进位
        int cur = 0, carry = 0;
        StringBuilder ret = new StringBuilder();
        while (cur < n + m - 1 || carry != 0) {
            if (cur < n + m - 1) {
                carry += temp[cur++];
            }
            ret.append(carry % 10);
            carry /= 10;
        }

        // 4、处理前导0
        while (ret.length() > 1 && ret.charAt(ret.length() - 1) == '0') {
            ret.deleteCharAt(ret.length() - 1);
        }

        return ret.reverse().toString();
    }
}
