public class LeetCode1768 {
    //给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。
    // 如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
    //
    //返回 合并后的字符串 。
    public String mergeAlternately(String word1, String word2) {
        StringBuilder mergeStr=new StringBuilder();
        int len1=word1.length(),len2=word2.length();
        int i=0,j=0;
        while(i<len1&&j<len2) {
            if(i==j) {
                mergeStr.append(word1.charAt(i));
                i++;
            } else {
                mergeStr.append(word2.charAt(j));
                j++;
            }

        }
        while(i!=len1) {
            mergeStr.append(word1.charAt(i));
            i++;
        }

        while(j!=len2) {
            mergeStr.append(word2.charAt(j));
            j++;
        }
        return mergeStr.toString();
    }
}
