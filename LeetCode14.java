public class LeetCode14 {
    //编写一个函数来查找字符串数组中的最长公共前缀。
    //
    //如果不存在公共前缀，返回空字符串 ""。
    public String longestCommonPrefix(String[] strs) {
        String ret=strs[0];
        for(int i=1;i<strs.length;i++) {
            int s1=0;
            int s2=0;
            String temp="";
            while(s1<ret.length()&&s2<strs[i].length()&&ret.charAt(s1)==strs[i].charAt(s2)) {
                temp+=strs[i].charAt(s1);
                s1++;
                s2++;

            }
            ret=temp;
        }

        return ret;
    }
}
