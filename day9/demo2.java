package day9;

public class demo2 {

    //给你一个字符串 s，找到 s 中最长的回文子串。
    //
    //如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
    public String longestPalindrome(String s) {
        if(s.length()==0 || s.length()==1) {
            return s;
        }
        String longestStr=null;
        int longest=0;
        for(int i=0;i<s.length();i++) {
            for(int j=i+1;j<=s.length();j++) {
                String temp=s.substring(i,j);
                if(isPalindrome(temp)) {
                    int len=temp.length();
                    if(len>=longest) {
                        longest=len;
                        longestStr=temp;
                    }
                }
            }

        }
        return longestStr;


    }

    public boolean isPalindrome(String s) {
        int right=s.length()-1;
        int left=0;
        while(left<right) {
            if(s.charAt(right)!=s.charAt(left)) {
                return false;
            }
            right--;
            left++;
        }
        return true;
    }
}
