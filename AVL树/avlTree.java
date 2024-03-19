public class avlTree {
    static class Node {
        public int val;
        public int bf;

        public Node left;
        public Node right;
        public Node parent;

        public Node(int val) {
            this.val = val;
        }
    }

    public boolean insert(Node root, int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            return true;
        }

        Node cur = root;
        Node parent = null;

        while (cur != null) {
            parent = cur;
            if (cur.val == value) {
                return false;
            } else if (cur.val > value) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        if (parent.val > value) {
            parent.left = node;
        } else {
            parent.right = node;
        }

        cur = node;
        node.parent = parent;

        while (parent != null) {
            if (parent.left == cur) {
                parent.bf--;
            } else {
                parent.bf++;
            }

            if (parent.bf == 0) {
                break;
            } else if (parent.bf == 1 || parent.bf == -1) {
                cur = parent;
                parent = cur.parent;
            } else {
                if (parent.bf == 2) {
                    if (cur.bf == 1) {
                        rotateL(parent, root);
                    } else {
                        //cur.bf==-1
                        rotateRL(parent, root);
                    }
                } else {
                    //parent.bf==-1
                    if (cur.bf == -1) {
                        rotateR(parent, root);
                    } else {
                        //cur.bf==1
                        rotateLR(parent, root);
                    }
                }
                break;
            }

        }
        return true;

    }

    private void rotateLR(Node parent, Node root) {
        Node subL = parent;
        Node subLR = subL.right;
        int bf = subLR.bf;
        rotateL(parent, root);
        rotateR(parent, root);

        if (bf == -1) {
            parent.bf = 1;
            subL.bf = 0;
            subLR.bf = 0;
        } else if (bf == 1) {
            subL.bf = -1;
            parent.bf = 0;
            subLR.bf = 0;
        }
    }

    private void rotateR(Node parent, Node root) {
        Node pParent = parent.parent;
        Node curL = parent.left;
        Node curLR = curL.right;
        parent.left = curLR;
        if (curLR != null) {
            curLR.parent = parent;
        }
        curL.right = parent;
        if (pParent == null) {
            curL.parent = null;
            root = curL;
        } else if (pParent.left == parent) {
            pParent.left = curL;
            curL.parent = pParent;
        } else {
            pParent.right = curL;
            curL.parent = pParent;
        }
        curL.bf = 0;
        parent.bf = 0;
    }

    private void rotateL(Node parent, Node root) {
        Node pParent = parent.parent;
        Node curR = parent.right;
        Node curRL = curR.left;
        parent.right = curRL;
        if (curRL != null) {
            curRL.parent = parent;
        }
        curR.left = parent;
        if (pParent == null) {
            curR.parent = null;
            root = curR;
        } else if (pParent.left == parent) {
            pParent.left = curR;
            curR.parent = pParent;
        } else {
            pParent.right = curR;
            curR.parent = pParent;
        }

        parent.parent = curR;
        parent.bf = 0;
        curR.bf = 0;

    }

    private void rotateRL(Node parent, Node root) {
        Node subR = parent.right;
        Node subRL = subR.left;
        int bf = subRL.bf;

        rotateR(parent, root);
        rotateL(parent, root);

        if (bf == -1) {
            subRL.bf = 0;
            subR.bf = 0;
            parent.bf = 1;
        } else if (bf == 1) {
            subRL.bf = 0;
            parent.bf = 0;
            subR.bf = -1;
        }

    }


    public void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

    public int getHeight(Node root) {
        if (root == null) {
            return 0;
        }

        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);

        return leftH > rightH ? leftH + 1 : rightH + 1;
    }

    public boolean isBalance(Node root) {
        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);

        //防止一种情况具体说就是左右转或右左转函数中的对于subRL等的bf的判断，判断条件要注意除去bf等于0的情况。
        if (rightH - leftH != root.bf) {
            System.out.println("平衡因子出错。");
            return false;
        }

        return (Math.abs(leftH - rightH) <= 1) && isBalance(root.right) && isBalance(root.left);
    }


}
