public class LeetCode2 {

    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    //给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
    //
    //请你将两个数相加，并以相同形式返回一个表示和的链表。
    //
    //你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int temp = 0;
        int carry = 0;
        ListNode head = new ListNode();
        ListNode cur = head;
        while (l1 != null && l2 != null) {

            temp = (l1.val + l2.val + carry) % 10;
            ListNode node = new ListNode(temp);
            cur.next = node;
            cur = cur.next;
            carry = (l1.val + l2.val + carry) / 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            temp = (l1.val + carry) % 10;
            ListNode node = new ListNode(temp);
            cur.next = node;
            cur = cur.next;
            carry = (l1.val + carry) / 10;
            l1 = l1.next;
        }

        while (l2 != null) {
            temp = (l2.val + carry) % 10;
            ListNode node = new ListNode(temp);
            cur.next = node;
            cur = cur.next;
            carry = (l2.val + carry) / 10;
            l2 = l2.next;
        }

        if (carry != 0) {
            ListNode node = new ListNode(carry);
            cur.next = node;
        }
        return head.next;

    }
}
