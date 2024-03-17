public class LeetCode1422 {
    public int maxScore(String s) {
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            String tempLeft = s.substring(0, i);
            String tempRight = s.substring(i, s.length());
            int count = 0;
            for (int i1 = 0; i1 < tempLeft.length(); i1++) {
                if (tempLeft.charAt(i1) == '0') {
                    count++;
                }
            }

            for (int i1 = 0; i1 < tempRight.length(); i1++) {
                if (tempRight.charAt(i1) == '1') {
                    count++;
                }
            }

            if (count > max) {
                max = count;
            }

        }
        return max;
    }
}
