public class LeetCode461 {
    public int hammingDistance(int x, int y) {
        int ret = 0;
        while (y != 0 || x != 0) {
            ret += (Math.abs((x & 1) - (y & 1)));
            x >>= 1;
            y >>= 1;
        }

        return ret;
    }
}
