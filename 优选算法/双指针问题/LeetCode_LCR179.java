public class LeetCode_LCR179 {
    public int[] twoSum(int[] price, int target) {
        int right = price.length - 1;
        int left = 0;

        while (left < right) {
            if (price[left] + price[right] > target) {
                right--;
            } else if (price[left] + price[right] < target) {
                left++;
            } else {
                break;
            }
        }

        return new int[] { price[left], price[right] };
    }
}
