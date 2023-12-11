package day7;

public class demo8 {
    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    //给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
    //
    //k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
    //
    //你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null) {
            return null;
        }
        ListNode cur=head;
        int len=0;
        while(cur!=null) {
            cur=cur.next;
            len++;
        }
        if(len==k) {
            return reverse(head);
        }
        ListNode endPre;
        ListNode end;
        if(len%k!=0) {
            endPre=findNode(head,len%k+1);
            end=findNode(head,len%k);
            endPre.next=null;

        } else {
            end=null;
            endPre=null;
        }

        head=reverse(head);
        ListNode tail=head;
        int count=k-1;
        while(count!=0) {
            tail=tail.next;
            count--;
        }
        ListNode temp=new ListNode(-1);
        ListNode Next=null;
        ListNode nextPre=null;
        cur=head;
        int tmp=0;
        while(head!=null) {
            tmp=k-1;
            while(tmp!=0) {
                cur=cur.next;
                tmp=tmp-1;
            }
            nextPre=cur;
            Next=cur.next;
            nextPre.next=temp.next;
            temp.next=head;
            head=Next;
            cur=Next;

        }
        tail.next=end;
        return temp.next;

    }

    public ListNode reverse(ListNode head) {
        ListNode temp=new ListNode(-1);

        while(head!=null) {
            ListNode headNext=head.next;
            head.next=temp.next;
            temp.next=head;
            head=headNext;
        }
        return temp.next;
    }

    public ListNode findNode(ListNode head,int k) {
        if(head==null) {
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(k!=1) {
            fast=fast.next;
            k=k-1;
        }

        while(fast.next!=null) {
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }


}
