import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode02_01 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            if (!set.contains(cur.val)) {
                set.add(cur.val);
                list.add(cur);
            }
            cur = cur.next;
        }

        ListNode temp = new ListNode(-1);
        cur = temp;
        for (ListNode node :
                list) {
            cur.next = node;
            cur = node;
        }
        cur.next = null;
        return temp.next;
    }
}
