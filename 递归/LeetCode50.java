public class LeetCode50 {
    public double myPow(double x, int n) {
        return n < 0 ? 1.0 / pow(x, -n) : pow(x, n);
    }

    public double pow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double temp = pow(x, n / 2);
        return n % 2 == 0 ? temp * temp : x * temp * temp;
    }
}
