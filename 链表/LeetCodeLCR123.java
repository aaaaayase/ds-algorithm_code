import java.util.Stack;

public class LeetCodeLCR123 {
    //书店店员有一张链表形式的书单，每个节点代表一本书，节点中的值表示书的编号。
    // 为更方便整理书架，店员需要将书单倒过来排列，就可以从最后一本书开始整理，逐一将书放回到书架上。
    // 请倒序返回这个书单链表。

    static public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int[] reverseBookList(ListNode head) {
        int len=0;
        if(head==null) {
            return new int[0];
        }
        ListNode cur=head;
        Stack<Integer> stack=new Stack<>();
        while(cur!=null) {
            stack.push(cur.val);
            len++;
            cur=cur.next;
        }

        int[] arr=new int[len];
        for(int i=0;i<len;i++) {
            arr[i]=stack.pop();
        }

        return arr;
    }
}
