public class LeetCode495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            if (timeSeries[i + 1] - timeSeries[i] >= duration) {
                sum += duration;
            } else {
                sum += (timeSeries[i + 1] - timeSeries[i]);
            }

        }
        sum += duration;

        return sum;
    }
}
