public class LeetCode2586 {

    public int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (is(words[i], i, left, right)) {
                count++;
            }
        }
        return count;
    }

    public boolean is(String word, int i, int left, int right) {
        int len = word.length();
        String temp = "aeiou";
        if (i <= right && i >= left && temp.contains(word.charAt(0) + "") && temp.contains("" + word.charAt(len - 1))) {
            return true;
        }
        return false;

    }
}
