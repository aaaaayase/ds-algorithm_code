public class LeetCode67 {
    //给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
    public String addBinary(String a, String b) {

        return addBinary1(a,b);
        //return addBinary2(a,b);
    }
    public String addBinary1(String a, String b) {
        int lenA=a.length();
        int lenB=b.length();

        String strL=a;
        String strS=b;

        StringBuilder tmp=new StringBuilder();

        if(lenA<=lenB) {
            strL=b;
            strS=a;
        }
        int carry=0;

        int len1=strL.length();
        int len2=strS.length();
        while(len2>0) {
            int plus=strL.charAt(len1-1)-'0'+strS.charAt(len2-1)-'0'+carry;

            carry=plus/2;
            tmp.insert(0,plus%2);

            len1--;
            len2--;

        }

        while(len1>0) {
            int plus=strL.charAt(len1-1)-'0'+carry;
            carry=plus/2;
            tmp.insert(0,plus%2);

            len1--;

        }

        if(carry!=0) {
            tmp.insert(0,carry);
        }
        return tmp.toString();
    }

    public String addBinary2(String a, String b) {
        return Integer.toBinaryString(
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );
    }

}
