import java.util.HashSet;
import java.util.Set;

public class LeetCode217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        for (int x : nums) {
            if (hash.contains(x)) {
                return true;
            }
            hash.add(x);
        }

        return false;
    }
}
