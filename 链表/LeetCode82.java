public class LeetCode82 {
    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    //给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回已排序的链表 。
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) {
            return null;
        }

        if(head.next==null) {
            return head;
        }

        ListNode pre=head;
        ListNode cur=head.next;
        int[] arr=new int[300];
        int index=0;
        while(cur!=null) {
            if(pre.val==cur.val) {
                if((index>=1&&arr[index-1]!=cur.val)||index==0) {
                    arr[index++]=cur.val;
                }

                ListNode curNext=cur.next;
                pre.next=curNext;
                cur=curNext;
            } else {
                pre=cur;
                cur=cur.next;
            }

        }

        int len=index;
        ListNode temp=new ListNode(101);
        temp.next=head;
        pre=temp;
        cur=temp.next;
        index=0;

        while(cur!=null) {
            if(index<len&&cur.val==arr[index]) {
                ListNode curNext=cur.next;
                pre.next=cur.next;
                cur=curNext;
                index++;
            } else {
                pre=cur;
                cur=cur.next;
            }


        }

        return temp.next;
    }
}
