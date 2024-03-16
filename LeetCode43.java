public class LeetCode43 {

    //给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
    //
    //注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int len1 = num1.length();
        int len2 = num2.length();

        String retS = "";
        for (int i = 0; i < len1; i++) {
            // 位数
            int n = len1 - i - 1;
            // 位置的数字
            int num = num1.charAt(i) - '0';
            StringBuilder temp = new StringBuilder(strMultiple(num2, num));
            while (n != 0) {
                temp.append(0);
                n--;
            }
            retS = strAdd(temp.toString(), retS);
        }

        return retS;
    }

    public String strMultiple(String str, int num) {
        StringBuilder retS = new StringBuilder();
        int carry = 0;
        int index = str.length() - 1;

        while (index >= 0) {

            int temp = (str.charAt(index) - '0') * num + carry;
            if (temp < 10) {
                retS.insert(0, temp);
                carry = 0;
            } else {
                carry = temp / 10;
                retS.insert(0, temp % 10);
            }
            index--;
        }

        if (carry != 0) {
            retS.insert(0, carry);
        }

        return retS.toString();
    }

    public String strAdd(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int carry = 0;
        int index1 = len1 - 1;
        int index2 = len2 - 1;

        StringBuilder retS = new StringBuilder();
        while (index1 >= 0 && index2 >= 0) {
            int temp = carry + (str1.charAt(index1) + str2.charAt(index2) - 2 * ('0'));
            if (temp < 10) {
                retS.insert(0, temp);
                carry = 0;
            } else {
                carry = temp / 10;
                retS.insert(0, temp % 10);
            }

            index1--;
            index2--;

        }

        while (index1 >= 0) {
            int temp = carry + (str1.charAt(index1) - '0');
            if (temp < 10) {
                retS.insert(0, temp);
                carry = 0;
            } else {
                carry = temp / 10;
                retS.insert(0, temp % 10);
            }
            index1--;

        }

        while (index2 >= 0) {
            int temp = carry + (str2.charAt(index2) - '0');
            if (temp < 10) {
                retS.insert(0, temp);
                carry = 0;
            } else {
                carry = temp / 10;
                retS.insert(0, temp % 10);
            }
            index2--;

        }

        if (carry != 0) {
            retS.insert(0, carry);
        }

        return retS.toString();

    }
}


