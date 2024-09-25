import java.util.*;

public class LeetCode269 {
    Map<Character, Set<Character>> edges;
    Map<Character, Integer> in;
    boolean check;

    public String alienOrder(String[] words) {
        int n = words.length;
        edges = new HashMap<>();
        in = new HashMap<>();
        // 初始化入度
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                char ch = words[i].charAt(j);
                in.put(ch, 0);
            }
        }

        // 建图
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                add(words[i], words[j]);
                if (check) {
                    return "";
                }
            }
        }

        // 建立队列
        Queue<Character> q = new LinkedList<>();
        StringBuilder ret = new StringBuilder();
        for (char ch : in.keySet()) {
            if (in.get(ch) == 0) {
                q.add(ch);
            }
        }

        while (!q.isEmpty()) {
            char temp = q.poll();
            ret.append(temp);

            if (!edges.containsKey(temp)) {
                continue;
            }

            for (char ch : edges.get(temp)) {
                in.put(ch, in.get(ch) - 1);
                if (in.get(ch) == 0) {
                    q.add(ch);
                }
            }
        }

        for (char ch : in.keySet()) {
            if (in.get(ch) != 0) {
                return "";
            }
        }

        return ret.toString();
    }

    public void add(String s1, String s2) {
        int n = Math.min(s1.length(), s2.length());
        int i = 0;

        for (; i < n; i++) {
            char ch1 = s1.charAt(i), ch2 = s2.charAt(i);
            if (ch1 != ch2) {
                if (!edges.containsKey(ch1)) {
                    edges.put(ch1, new HashSet<>());
                }
                if (!edges.get(ch1).contains(ch2)) {
                    edges.get(ch1).add(ch2);
                    in.put(ch2, in.get(ch2) + 1);
                }

                break;
            }
        }

        if (i == s2.length() && i < s1.length()) {
            check = true;
        }
    }
}
