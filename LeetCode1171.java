import java.util.Stack;

public class LeetCode1171 {
    static class ListNode {
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

    //给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
    //
    //删除完毕后，请你返回最终结果链表的头节点。
    //
    //
    //
    //你可以返回任何满足题目要求的答案。
    //
    //（注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。）
    public ListNode removeZeroSumSublists(ListNode head) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        ListNode cur = head;
        while (cur != null) {

            int sum = cur.val;
            while (sum !=0 && !stack1.isEmpty()) {
                sum += stack1.peek().val;
                stack2.push(stack1.pop());
            }
            if (sum>0 || sum <0) {
                while (!stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }
                stack1.push(cur);
            } else {
                while (!stack2.isEmpty()) {
                    stack2.pop();
                }
            }

            cur = cur.next;
        }

        ListNode temp=new ListNode(-1);
        temp.next=null;
        while (!stack1.isEmpty()) {
            cur=stack1.pop();

            cur.next=temp.next;
            temp.next=cur;
        }
        return temp.next;
    }
}
