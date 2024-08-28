import java.util.ArrayList;

public class LeetCode429 {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        queue.add(root);
        while (queue.size()!=0) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            while (size-- != 0) {
                Node head = queue.poll();
                temp.add(head.val);
                List<Node> children = head.children;
                for (Node child : children) {
                    if (child != null)
                        queue.add(child);
                }
            }
            ret.add(temp);
        }
        return ret;
    }
}
