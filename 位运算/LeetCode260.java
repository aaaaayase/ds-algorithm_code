public class LeetCode260 {
    public int[] singleNumber(int[] nums) {
        int sum = 0;

        for (int x : nums) {
            sum ^= x;
        }

        sum = (sum == Integer.MIN_VALUE ? Integer.MIN_VALUE : (sum & -sum));

        int[] arr = new int[2];
        for (int x : nums) {
            if ((sum & x) != sum) {
                arr[0] ^= x;
            } else {
                arr[1] ^= x;
            }
        }

        return arr;
    }
}
