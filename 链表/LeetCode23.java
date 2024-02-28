public class LeetCode23 {

    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    //给你一个链表数组，每个链表都已经按升序排列。
    //请你将所有链表合并到一个升序链表中，返回合并后的链表。
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0) {
            return null;
        }
        ListNode ret = lists[0];
        for (int i = 1; i < lists.length; i++) {
            ret=mergeTwoLists(ret,lists[i]);
        }
        return ret;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur=head;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null && p2 != null) {

            if (p1.val <= p2.val) {
                cur.next = p1;
                cur = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                cur = p2;
                p2 = p2.next;
            }

        }

        if (p1!=null) {
            cur.next=p1;
        }

        if (p2!=null) {
            cur.next=p2;
        }
        return head.next;
    }
}
