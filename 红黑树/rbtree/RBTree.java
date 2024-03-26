package rbtree;

public class RBTree {
    public static class RBTreeNode {
        public int val;
        public RBTreeNode left;
        public RBTreeNode right;
        public RBTreeNode parent;
        public Color color;

        public RBTreeNode(int val) {
            this.val = val;
            this.color = Color.RED;
        }
    }

    public RBTreeNode root;


    public boolean insert(int key) {
        RBTreeNode node = new RBTreeNode(key);

        if (root == null) {
            root = node;
            root.color = Color.BLACK;
            return true;
        }

        RBTreeNode cur = root;
        RBTreeNode parent = null;

        while (cur != null) {
            parent = cur;
            if (cur.val < key) {
                cur = cur.right;
            } else if (cur.val > key) {
                cur = cur.left;
            } else {
                return false;
            }
        }

        if (key > parent.val) {
            parent.right = node;
        }

        if (key < parent.val) {
            parent.left = node;
        }

        cur = node;
        parent = cur.parent;


        while (parent != null && parent.color == Color.RED) {
            RBTreeNode grandF = parent.parent;
            if (grandF.left == parent) {
                RBTreeNode uncle = grandF.right;
                if (uncle != null && uncle.color == Color.RED) {
                    parent.color = Color.BLACK;
                    uncle.color = Color.BLACK;
                    grandF.color = Color.RED;
                    cur = grandF;
                    parent = cur.parent;
                } else {
                    if (parent.right == cur) {
                        rotateLeft(parent);
                        RBTreeNode temp = cur;
                        cur = parent;
                        parent = cur;
                    }


                    rotateRight(grandF);
                    grandF.color = Color.RED;
                    parent.color = Color.BLACK;

                }


            } else {
                RBTreeNode uncle = grandF.left;
                if (uncle != null && uncle.color == Color.RED) {
                    parent.color = Color.BLACK;
                    uncle.color = Color.BLACK;
                    grandF.color = Color.RED;
                    cur = grandF;
                    parent = cur.parent;

                } else {
                    if (parent.left == cur) {
                        rotateRight(parent);
                        RBTreeNode temp = cur;
                        cur = parent;
                        parent = cur;
                    }


                    rotateLeft(grandF);
                    grandF.color = Color.RED;
                    parent.color = Color.BLACK;

                }


            }

        }
        root.color = Color.BLACK;
        return true;
    }

    public void rotateRight(RBTreeNode parent) {
        RBTreeNode pParent = parent.parent;
        RBTreeNode subL = parent.left;
        RBTreeNode subLR = subL.right;
        parent.left = subLR;
        if (subLR != null) {
            subLR.parent = parent;
        }
        if (pParent == null) {
            subL.parent = null;
            root = subL;
        } else if (pParent.left == parent) {
            pParent.left = subL;
            subL.parent = pParent;
        } else {
            pParent.right = subL;
            subL.parent = pParent;
        }
        parent.parent = subL;
        subL.right = parent;
    }


    public void rotateLeft(RBTreeNode parent) {
        RBTreeNode pParent = parent.parent;
        RBTreeNode subR = parent.right;
        RBTreeNode subRL = subR.left;
        parent.right = subRL;
        if (subRL != null) {
            subRL.parent = parent;
        }
        subR.left = parent;
        parent.parent = subR;
        if (pParent == null) {
            subR.parent = null;
            root = subR;
        } else if (pParent.left == parent) {
            pParent.left = subR;
            subR.parent = pParent;
        } else {
            pParent.right = subR;
            subR.parent = pParent;
        }
    }


    public boolean isRBTree(RBTreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.color != Color.BLACK) {
            return false;
        }

        int blackNum = 0;
        RBTreeNode cur = root;
        while (cur != null) {
            if (cur.color == Color.BLACK) {
                blackNum++;
            }
            cur = cur.left;
        }


        return checkBlackNum(root, 0, blackNum) && checkRedColor(root);
    }


    public boolean checkRedColor(RBTreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.color == Color.RED) {
            if (root.parent.color==Color.RED) {
                return false;
            }
        }

        return checkRedColor(root.left) && checkRedColor(root.right);

    }

    public boolean checkBlackNum(RBTreeNode root, int pathBlackBum, int blackNum) {
        if (root == null) {
            return true;
        }
        if (root.color == Color.BLACK) {
            pathBlackBum++;
        }
        if (root.left == null && root.right == null) {
            if (pathBlackBum != blackNum) {
                return false;
            }
        }

        return checkBlackNum(root.left, pathBlackBum, blackNum) && checkBlackNum(root.right, pathBlackBum, blackNum);
    }

}
