public class LeetCode58 {
    //给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
    //
    //单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。

    public int lengthOfLastWord(String s) {
        s=s.strip();
        String[] strs=s.split(" ");
        return strs[strs.length-1].length();
    }
}
