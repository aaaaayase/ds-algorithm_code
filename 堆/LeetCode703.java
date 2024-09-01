import java.util.PriorityQueue;

public class LeetCode703 {
    class KthLargest {

        private int k = 0;
        private PriorityQueue<Integer> heap;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            heap = new PriorityQueue<>();
            for (int x : nums) {
                heap.add(x);
                if (heap.size() > k) {
                    heap.poll();
                }
            }
        }

        public int add(int val) {
            heap.add(val);
            if (heap.size() > k) {
                heap.poll();
            }
            return heap.peek();
        }
    }
}
