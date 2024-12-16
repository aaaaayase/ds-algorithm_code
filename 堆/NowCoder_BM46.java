import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author yun
 * @date 2024/12/16 12:00
 * @desciption: 最小的K个数
 */
public class NowCoder_BM46 {
    public ArrayList<Integer> GetLeastNumbers_Solution (int[] inputs, int k) {
        // write code here
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b)->b - a);
        for (int input : inputs) {
            heap.offer(input);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int size = heap.size();
        ArrayList<Integer> ret = new ArrayList<>();
        while (size-- != 0) {
            int temp = heap.poll();
            ret.add(0, temp);
        }
        return ret;

    }
}
