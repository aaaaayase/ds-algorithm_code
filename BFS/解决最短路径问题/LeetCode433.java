package org.yun.dailycode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LeetCode433 {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> hash = new HashSet<>();
        Set<String> vis = new HashSet<>();
        char[] chs = {'A', 'C', 'G', 'T'};
        for (String str : bank) {
            hash.add(str);
        }

        if (startGene.equals(endGene)) {
            return 0;
        }

        if (!hash.contains(endGene)) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        vis.add(startGene);

        int ret = 0;

        while (!queue.isEmpty()) {
            ret++;
            int size = queue.size();
            while (size-- != 0) {
                String t = queue.poll();
                for (int i = 0; i < 8; i++) {
                    char[] temp = t.toCharArray();
                    for (int j = 0; j < 4; j++) {
                        temp[i] = chs[j];
                        String next = new String(temp);
                        if (!vis.contains(next) && hash.contains(next)) {
                            if (next.equals(endGene)) {
                                return ret;
                            }
                            queue.add(next);
                            vis.add(next);
                        }
                    }
                }
            }

        }
        return -1;
    }
}
