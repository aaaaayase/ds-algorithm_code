import java.util.*;

public class LeetCode127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> hash = new HashSet<String>();
        for (String str : wordList) {
            hash.add(str);
        }
        Set<String> vis = new HashSet<String>();
        Queue<String> q = new LinkedList<>();
        int ret = 1;
        q.add(beginWord);
        vis.add(beginWord);
        while (!q.isEmpty()) {
            int sz = q.size();
            ret++;
            while (sz-- != 0) {
                String s = q.poll();
                for (int i = 0; i < s.length(); i++) {
                    char[] ss = s.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        ss[i] = ch;
                        String temp = new String(ss);
                        if (hash.contains(temp) && !vis.contains(temp)) {
                            if (temp.equals(endWord)) {
                                return ret;
                            }
                            q.add(temp);
                            vis.add(temp);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
