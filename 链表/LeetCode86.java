public class LeetCode86 {
    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    //给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
    //你应当 保留 两个分区中每个节点的初始相对位置。
    public ListNode partition(ListNode head, int x) {
        ListNode head1=new ListNode();
        ListNode head2=new ListNode();
        ListNode l1=head1;
        ListNode l2=head2;

        if(head==null) {
            return null;
        }
        if(head.next==null) {
            return head;
        }

        ListNode cur=head;
        while(cur!=null) {
            ListNode curNext=cur.next;
            if(cur.val<x) {
                cur.next=l1.next;
                l1.next=cur;
                l1=cur;
            } else {
                cur.next=l2.next;
                l2.next=cur;
                l2=cur;
            }

            cur=curNext;
        }

        l1.next=head2.next;
        head2=null;
        return head1.next;
    }

}
