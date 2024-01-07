public class LeetCode459 {

    //给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
    public boolean repeatedSubstringPattern(String s) {
        //return repeatedSubstringPattern1(s);
        return repeatedSubstringPattern(s);


    }


    public boolean repeatedSubstringPattern1(String s) {
        if (s.length() == 1) {
            return false;
        }
        int len = s.length();
        for (int i = 1; i <= len / 2; i++) {
            if (len % i == 0) {
                boolean match = true;
                for (int j = i; j < len; j++) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean repeatedSubstringPattern2(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }
}
