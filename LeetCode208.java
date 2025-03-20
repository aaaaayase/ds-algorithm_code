/**
 * @author yun
 * @date 2025/3/20 23:44
 * @desciption: 208. 实现 Trie (前缀树)
 */
class TrieNode {
    boolean isEnd;
    Map<Character, TrieNode> map;

    public TrieNode() {
        map = new HashMap<>();
    }

}
public class LeetCode208 {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (!cur.map.containsKey(word.charAt(i))) {
                cur.map.put(word.charAt(i), new TrieNode());
            }
            cur = cur.map.get(word.charAt(i));
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (!cur.map.containsKey(word.charAt(i))) {
                return false;
            }
            cur = cur.map.get(word.charAt(i));
        }

        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            if(!cur.map.containsKey(prefix.charAt(i))) {
                return false;
            }
            cur=cur.map.get(prefix.charAt(i));
        }

        return true;
    }
}
