import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode2208 {

    public int halveArray(int[] nums) {

        PriorityQueue<Double> q = new PriorityQueue<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return o2.compareTo(o1);
            }
        });

        double sum = 0;
        for (int i = 0; i < nums.length; i++) {
            q.offer(nums[i] * 1.0);
            sum += nums[i];
        }

        int count = 0;
        double tSum = sum;
        while (true) {
            if (tSum <= sum / 2.0) {
                return count;
            }
            double temp = q.poll();
            q.offer(temp / 2);
            tSum -= temp / 2.0;
            count++;

        }

    }
}
