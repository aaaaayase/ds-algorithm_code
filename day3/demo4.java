package day3;

public class demo4 {
    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    //给你两个单链表的头节点 headA 和 headB ，
    //请你找出并返回两个单链表相交的起始节点。
    //如果两个链表不存在相交节点，返回 null。
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null) {
            curA = curA.next;
            lenA++;
        }
        while (curB != null) {
            curB = curB.next;
            lenB++;
        }

        int len = lenA - lenB;
        ListNode listL = headA;
        ListNode listS = headB;
        if (len < 0) {
            len = lenB - lenA;
            listL = headB;
            listS = headA;
        }

        while (len != 0) {
            listL = listL.next;
            len--;
        }

        while (listS != null && listL != null && listL != listS) {
            listL = listL.next;
            listS = listS.next;
        }

        if (listL == listS && listL == null) {
            return null;
        }

        return listL;
    }

}
