import java.util.ArrayList;

public class LeetCode143 {
    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    //给定一个单链表 L 的头节点 head ，单链表 L 表示为：
    //
    //L0 → L1 → … → Ln - 1 → Ln
    //请将其重新排列后变为：
    //
    //L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
    //不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
    public void reorderList(ListNode head) {
        ArrayList<ListNode> list = new ArrayList();
        if (head == null) {
            return;
        }

        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }

        int right = list.size() - 1;
        int left = 0;

        ListNode l = new ListNode();
        cur = l;
        while (right > left) {
            ListNode leftNode = list.get(left);
            ListNode rightNode = list.get(right);
            cur.next = leftNode;
            cur = leftNode;
            leftNode.next = null;
            cur.next = rightNode;
            cur = rightNode;
            rightNode.next = null;
            right--;
            left++;
        }

        if (list.size() % 2 != 0) {
            ListNode tailNode = list.get(list.size() / 2);
            cur.next = tailNode;
            tailNode.next = null;
        }

        head = l.next;

    }
}
