package day3;

public class demo3 {

    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    //对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。
    //
    //给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。保证链表长度小于等于900。
    public boolean chkPalindrome(ListNode A) {
        // write code here
        ListNode fast = A;
        ListNode slow = A;
        //找出中间点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //反转
        ListNode cur = slow.next;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;

        }

        fast = A;
        //遍历确认是否为回文串
        while (slow != fast) {
            if (slow.val != fast.val) {
                return false;
            }

            if (fast.next==slow) {
                return true;
            }
            fast=fast.next;
            slow=slow.next;

        }
        return true;
    }
}
