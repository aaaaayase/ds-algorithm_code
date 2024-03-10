import java.util.Arrays;

public class LeetCode1160 {
    //给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
    //
    //假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
    //
    //注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
    //
    //返回词汇表 words 中你掌握的所有单词的 长度之和。
    public int countCharacters(String[] words, String chars) {
        int[] arr = new int[26];
        for (char ch : chars.toCharArray()) {
            arr[ch - 'a'] += 1;
        }
        int sum = 0;
        int[] temp = new int[26];
        for (String word : words) {
            boolean flg = true;
            temp = Arrays.copyOf(arr, arr.length);
            for (int i = 0; i < word.length(); i++) {
                temp[word.charAt(i) - 'a'] -= 1;
            }

            for (int i = 0; i < temp.length; i++) {
                if (temp[i] < 0) {
                    flg = false;
                }
            }
            if (flg) {
                sum += word.length();
            }
        }
        return sum;
    }
}
