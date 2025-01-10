import java.util.HashMap;
import java.util.Map;

/**
 * @author yun
 * @date 2025/1/10 10:58
 * @desciption: 同构字符串
 */
public class LeetCode205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> hashS = new HashMap<>();
        Map<Character, Character> hashT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char chS = s.charAt(i), chT = t.charAt(i);
            if ((hashS.containsKey(chS) && hashS.get(chS) != chT) || (hashT.containsKey(chT) && hashT.get(chT) != chS)) {
                return false;
            }
            hashS.put(chS, chT);
            hashT.put(chT, chS);
        }
        return true;
    }
}
