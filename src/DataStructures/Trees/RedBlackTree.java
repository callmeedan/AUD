package DataStructures.Trees;

public class RedBlackTree extends BinarySearchTree {
    private final TreeNode sent;

    public RedBlackTree() {
        super();
        this.sent = new TreeNode(Integer.MIN_VALUE);
        this.sent.color = NodeColor.BLACK;
        this.sent.parent = this.sent;
        this.sent.left = this.sent;
        this.sent.right = this.sent;
        this.root.parent = this.sent;
    }

    @Override
    public void insert(TreeNode z) {
        TreeNode x = this.root;
        TreeNode px = this.sent;
        while (x != null) {
            px = x;
            if (x.val > z.val) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.parent = px;
        if (px == this.sent) {
            this.root = z;
        } else {
            if (px.val > z.val) {
                px.left = z;
            } else {
                px.right = z;
            }
        }
        z.color = NodeColor.RED;
        fixColorsAfterInsertion(z);
    }

    private void fixColorsAfterInsertion(TreeNode z) {
        TreeNode y;
        while (z.parent.color == NodeColor.RED) {
            if (z.parent == z.parent.parent.left) {
                y = z.parent.parent.right;
                if (y!= null && y.color == NodeColor.RED) {
                    z.parent.color = NodeColor.BLACK;
                    y.color = NodeColor.BLACK;
                    z.parent.parent.color = NodeColor.RED;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.parent.right) {
                        z = z.parent;
                        rotateLeft(z);
                    }
                    z.parent.color = NodeColor.BLACK;
                    z.parent.parent.color = NodeColor.RED;
                    rotateRight(z.parent.parent);
                }
            } else {
                y = z.parent.parent.left;
                if (y!= null && y.color == NodeColor.RED) {
                    z.parent.color = NodeColor.BLACK;
                    y.color = NodeColor.BLACK;
                    z.parent.parent.color = NodeColor.RED;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.parent.left) {
                        z = z.parent;
                        rotateLeft(z);
                    }
                    z.parent.color = NodeColor.BLACK;
                    z.parent.parent.color = NodeColor.RED;
                    rotateRight(z.parent.parent);
                }
            }
        }
        this.root.color = NodeColor.BLACK;
    }

    public void rotateLeft(TreeNode x) {
        TreeNode y = x.right;
        x.right = y.left;
        if (y.left != null){
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == this.sent) {
            this.root = y;
        } else {
            if (x==x.parent.left) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
        }
        y.left = x;
        x.parent = y;
    }

    public void rotateRight(TreeNode x) {
        TreeNode y = x.left;
        x.left = y.right;
        if (y.right != null){
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == this.sent) {
            this.root = y;
        } else {
            if (x==x.parent.right) {
                x.parent.right = y;
            } else {
                x.parent.left = y;
            }
        }
        y.right = x;
        x.parent = y;
    }

}
