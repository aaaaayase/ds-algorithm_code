package day7;

public class demo9 {

    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) {
            return null;
        }
        int len=0;
        ListNode temp=head;
        while(temp!=null) {
            temp=temp.next;
            len++;
        }
        if(k%len==0) {
            return head;
        }
        ListNode pre=findNode(head,k%len+1);
        ListNode cur=findNode(head,k%len);
        ListNode tail=findNode(head,1);
        pre.next=null;
        tail.next=head;
        return cur;
    }


    public ListNode findNode(ListNode head, int k) {
        if(head==null) {
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(k!=1) {
            fast=fast.next;
            k--;
        }
        while(fast.next!=null) {
            fast=fast.next;
            slow=slow.next;

        }
        return slow;
    }
}
