import java.util.Scanner;
//编一个程序，读入用户输入的一串先序遍历字符串，根据此字符串建立一个二叉树（以指针方式存储）。
//例如如下的先序遍历字符串： ABC##DE#G##F### 其中“#”表示的是空格，空格字符代表空树。
//建立起此二叉树以后，再对二叉树进行中序遍历，输出遍历结果。
class TreeNode {
    public char val;
    TreeNode left;
    TreeNode right;
    public TreeNode(char val) {
        this.val=val;
    }
}
public class NowCoder_KY11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str=in.nextLine();
            TreeNode root=createTree(str);
            inOrder(root);
        }
    }

    public static int i=0;

    public static TreeNode createTree(String str) {
        TreeNode root=null;
        if(str.charAt(i)!='#') {
            root=new TreeNode(str.charAt(i));
            i++;
            root.left=createTree(str);
            root.right=createTree(str);
        } else {
            i++;
        }

        return root;
    }

    public static void inOrder(TreeNode root) {
        if(root==null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }
}
