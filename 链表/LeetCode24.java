public class LeetCode24 {
    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    //给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
    //你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
    public ListNode swapPairs(ListNode head) {
        int len = 0;
        ListNode cur = head, end;
        ListNode temp = new ListNode();
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return head;
        }
        while (cur.next.next != null) {
            len++;
            cur = cur.next;
        }
        if ((len + 2) % 2 != 0) {
            end = cur.next;
            cur.next = null;
        } else {
            end = null;
        }
        head = reverse(head);
        ListNode tail = head.next;
        while (head != null) {
            ListNode hNext = head.next.next;
            ListNode headNext = head.next;
            headNext.next = temp.next;
            temp.next = head;
            head = hNext;
        }
        tail.next = end;
        return temp.next;

    }

    public ListNode reverse(ListNode head) {
        ListNode temp = new ListNode();
        while (head != null) {
            ListNode headNext = head.next;
            head.next = temp.next;
            temp.next = head;
            head = headNext;
        }
        return temp.next;
    }
}

    