public class LeetCode1816 {

    //句子 是一个单词列表，列表中的单词之间用单个空格隔开，且不存在前导或尾随空格。
    //每个单词仅由大小写英文字母组成（不含标点符号）。
    public String truncateSentence(String s, int k) {
        String[] words=s.split(" ");
        String ret="";
        for (int i = 0; i < k; i++) {
            ret+=words[i];
            ret+=" ";
        }
        return ret.trim();
    }
}
