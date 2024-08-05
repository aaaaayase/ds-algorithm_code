import java.util.List;

public class LeetCode0806 {
    public void hanota(List<Integer> a, List<Integer> b, List<Integer> c) {

        int n = a.size();
        f(a, b, c, n);

    }

    public void f(List<Integer> a, List<Integer> b, List<Integer> c, int n) {
        if (n == 1) {
            c.add(a.remove(a.size() - 1));
            return;
        }

        f(a, c, b, n - 1);
        c.add(a.remove(a.size() - 1));
        f(b, a, c, n - 1);
    }
}
