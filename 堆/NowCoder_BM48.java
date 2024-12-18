import java.util.PriorityQueue;

/**
 * @author yun
 * @date 2024/12/16 12:00
 * @desciption: 数据流中的中位数
 */
public class NowCoder_BM48 {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public void Insert(Integer num) {
        if (maxHeap.isEmpty()||maxHeap.peek()>=num) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        // 保持两个堆的大小差不超过1
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public Double GetMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return (double) maxHeap.peek();
        }
    }
}
