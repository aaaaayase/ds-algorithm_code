public class LeetCode371 {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            int mul = a ^ b;
            a = mul;
            b = carry;
        }
        return a;
    }
}
