public class LeetCode389 {
    //给定两个字符串 s 和 t ，它们只包含小写字母。
    //
    //字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
    //
    //请找出在 t 中被添加的字母。
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
