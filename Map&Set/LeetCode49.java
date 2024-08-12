import java.util.*;

public class LeetCode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hash = new HashMap<>();

        for (String str : strs) {
            char[] tempArr = str.toCharArray();
            Arrays.sort(tempArr);
            String tempS = new String(tempArr);

            if (!hash.containsKey(tempS)) {
                hash.put(tempS, new ArrayList<>());
            }
            hash.get(tempS).add(str);
        }

        return new ArrayList(hash.values());
    }
}

