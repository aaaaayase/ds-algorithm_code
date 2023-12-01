package day3;

public class demo1 {
    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    //给你一个链表的头节点 head ，判断链表中是否有环。
    public boolean hasCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null) {

            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow) {
                return true;
            }

        }
        return false;
    }

}
