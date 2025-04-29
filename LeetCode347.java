/**
 * @author yun
 * @date 2025/4/29 21:38
 * @desciption:
 */
public class LeetCode374 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] count = new ArrayList[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            int key = entry.getKey();
            if (count[val] == null) {
                count[val] = new ArrayList();
            }
            count[val].add(key);
        }
        int[] ret = new int[k];
        int index = 0;
        for (int i = count.length - 1; i >= 0; i--) {
            if (count[i] != null) {
                for (int temp : count[i]) {
                    ret[index++] = temp;
                    if (index == k) {
                        return ret;
                    }
                }

            }

        }

        return ret;
    }

}
