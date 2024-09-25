import java.util.*;

public class LeetCode210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> retT = new ArrayList<>();

        int[] in = new int[numCourses];
        Map<Integer, List<Integer>> edges = new HashMap<>();

        int n = prerequisites.length;
        for (int i = 0; i < n; i++) {
            int a = prerequisites[i][0], b = prerequisites[i][1];
            if (!edges.containsKey(b)) {
                edges.put(b, new ArrayList<>());
            }
            edges.get(b).add(a);
            in[a]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int temp = q.poll();
            retT.add(temp);
            for (int x : edges.getOrDefault(temp, new ArrayList<>())) {
                in[x]--;
                if (in[x] == 0) {
                    q.add(x);
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (in[i] != 0) {
                return new int[]{};
            }
        }

        int[] ret = new int[retT.size()];
        int i = 0;
        for (int x : retT) {
            ret[i++] = x;
        }

        return ret;
    }
}
