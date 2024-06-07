public class LeetCode11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, area = 0;
        while (left < right) {
            int temp = Math.min(height[left], height[right]) * (right - left);
            area = Math.max(temp, area);
            if (height[left] >= height[right]) {
                right--;
            } else if (height[left] < height[right]) {
                left++;
            }

        }
        return area;
    }
}
