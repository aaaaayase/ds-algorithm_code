public class LeetCode28 {
    //给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
    // 如果 needle 不是 haystack 的一部分，则返回  -1 。
    public char findTheDifference(String s, String t) {
        int sum=0;

        for(char c : t.toCharArray()) {
            sum+=c-'a';
        }

        for(char c : s.toCharArray()) {
            sum-=c-'a';
        }

        return (char)(sum+'a');
    }
}
