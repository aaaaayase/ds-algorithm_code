import java.util.PriorityQueue;

/**
 * @author yun
 * @date 2024/12/16 12:00
 * @desciption: 寻找第K大
 */
public class NowCoder_BM47 {
    public int findKth (int[] a, int n, int K) {
        // write code here
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            heap.offer(a[i]);
            if (heap.size() > K) {
                heap.poll();
            }
        }

        return heap.peek();
    }
}
