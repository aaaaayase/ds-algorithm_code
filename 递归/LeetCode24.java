public class LeetCode24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = swapPairs(head.next.next);
        ListNode ret = head.next;
        ret.next = head;
        head.next = newHead;
        return ret;
    }
}
