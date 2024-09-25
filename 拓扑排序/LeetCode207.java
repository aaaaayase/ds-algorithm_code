import java.util.*;

public class LeetCode207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 入度记录
        int[] in = new int[numCourses];
        Map<Integer, List<Integer>> edges = new HashMap<>();
        int n = prerequisites.length;
        // 建图
        for (int i = 0; i < n; i++) {
            int a = prerequisites[i][0], b = prerequisites[i][1];
            if (!edges.containsKey(b)) {
                edges.put(b, new ArrayList<>());
            }
            edges.get(b).add(a);
            in[a]++;
        }

        Queue<Integer> q = new LinkedList<>();

        // 将入度为0的点加入队列
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            Integer temp = q.poll();
            for (Integer x : edges.getOrDefault(temp, new ArrayList<>())) {
                in[x]--;
                if (in[x] == 0) {
                    q.add(x);
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (in[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
