public class LeetCode338 {

    public int[] countBits(int n) {
        int[] answer = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            answer[i] = countOnes(i);
        }

        return answer;
    }

    public int countOnes(int n) {
        int count = 0;
        while (n != 0) {
            if ((n | 1) == n) {
                count++;
            }
            n = (n >> 1);
        }
        return count;
    }

}
