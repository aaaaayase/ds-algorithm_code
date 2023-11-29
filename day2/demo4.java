package day2;

public class demo4 {

    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    //输入一个链表，输出该链表中倒数第k个结点。
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0)
            return null;
        ListNode fast = head;
        ListNode slow = head;

        int count = 0;
        while (count != k - 1) {
            if (fast.next != null) {
                count++;
                fast = fast.next;
            } else {
                return null;
            }

        }

        while (fast.next != null) {

            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
