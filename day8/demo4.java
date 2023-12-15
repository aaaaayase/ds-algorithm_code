package day8;

public class demo4 {

    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    //给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
    public ListNode reverseList(ListNode head) {
        if(head==null) {
            return null;
        }

        ListNode temp=new ListNode();
        ListNode cur=head;
        while(cur!=null) {
            ListNode curNext=cur.next;
            cur.next=temp.next;
            temp.next=cur;
            cur=curNext;
        }
        return temp.next;
    }
}
