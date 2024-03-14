public class MyQueue {

    private static class ListNode {

        ListNode pre;
        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
        }
    }

    ListNode head;
    ListNode last;

    //尾插头删
    public void offer(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
            last = node;
        } else {
            last.next = node;
            node.pre = last;
            last = node;

        }
    }

    public void poll() {
        if (head == null) {
            return;
        }

        if (head.next == null) {
            head = null;
            last = null;
        }


        head = head.next;
        head.pre = null;


    }

    public int peek() {
        if (head == null) {
            return -1;
        }
        return head.val;
    }

    public boolean empty() {
        return head == null;
    }


}
