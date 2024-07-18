import java.util.HashMap;
import java.util.Map;

public class LeetCode1419 {
    public int minNumberOfFrogs(String croakOfFrogs) {
        String s = "croak";
        int n = s.length();
        int[] hash = new int[n];
        Map<Character, Integer> index = new HashMap<>();

        for (int i = 0; i < n; i++) {
            index.put(s.charAt(i), i);
        }

        for (char ch : croakOfFrogs.toCharArray()) {
            int i = index.get(ch);
            if (i == 0) {
                if (hash[n - 1] != 0) {
                    hash[n - 1]--;
                }
                hash[0]++;
            } else {

                if (hash[i - 1] == 0) {
                    return -1;
                } else {
                    hash[i - 1]--;
                    hash[i]++;
                }
            }
        }

        for (int i = 0; i < n - 1; i++) {
            if (hash[i] != 0) {
                return -1;
            }
        }

        return hash[n - 1];

    }
}
