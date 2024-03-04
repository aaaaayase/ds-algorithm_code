public class BinarySearchTree {

    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode root;

    public boolean search(int val) {
        TreeNode cur = root;
        while (cur != null) {
            if (val > cur.val) {
                cur = cur.right;
            } else if (val < cur.val) {
                cur = cur.left;
            } else {
                return true;
            }
        }
        return false;
    }

    public void insert(int val) {
        TreeNode node = new TreeNode(val);
        if (root == null) {
            root = node;
            return;
        }
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur != null) {
            parent = cur;
            if (val > cur.val) {
                cur = cur.right;
            } else if (val < cur.val) {
                cur = cur.left;
            } else {
                return;
            }

        }

        if (val > parent.val) {
            parent.right = node;
        } else {
            parent.left = node;
        }

    }

    public void remove(int val) {

        TreeNode parent = null;
        TreeNode cur = root;
        while (cur != null) {
            parent = cur;
            if (val > cur.val) {
                cur = cur.right;

            } else if (val < cur.val) {
                cur = cur.left;
            } else {
                removeNode(parent, cur);
                return ;
            }
        }

    }

    public void removeNode(TreeNode parent, TreeNode cur) {
        if (cur.left == null) {
            if (root == cur) {
                root = cur.right;
            } else if (cur == parent.left) {
                parent.left = cur.right;
            } else if (cur == parent.right) {
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            if (root == cur) {
                root = cur.left;
            } else if (parent.left == cur) {
                parent.left = cur.left;
            } else if (parent.right == cur) {
                parent.right = cur.left;
            }

        } else {
            TreeNode tp = cur;
            TreeNode t = cur.right;
            while (t.left != null) {
                tp=t;
                t=t.left;
            }
            cur.val=t.val;
            if(tp.left==t) {
                tp.left=t.right;
            } else {
                tp.right=t.right;
            }

        }

    }
}
