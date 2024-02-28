public class LeetCode19 {

    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }


    //给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        int len = 0;
        while (fast != null) {
            len++;
            fast = fast.next;
        }
        fast = head;

        if (len == n) {
            head = head.next;
        } else {
            while (n != 0) {
                fast = fast.next;
                n--;
            }

            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            ListNode temp = slow.next;
            slow.next = temp.next;
            return head;
        }


        return head;
    }

}
