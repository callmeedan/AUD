package DataStructures.Trees;

public class BinaryTree implements Tree {
    TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    public void btInorder() {
        inorder(root);
    }

    public void btPreorder() {
        preorder(root);
    }

    public void btPostorder() {
        postorder(root);
    }

    @Override
    public TreeNode search(TreeNode x, int k) {
        if (x == null || x.val == k) {return x;}
        TreeNode y = search(x.left, k);
        if (y != null) {return y;}
        return search(x.right, k);
    }

    public TreeNode btSearch(int k) {
        return search(root, k);
    }

    @Override
    public void insert(TreeNode x) {
        if (this.root != null) {
            this.root.parent = x;
            x.left = this.root;
        }
        this.root = x;
    }

    @Override
    public void delete(TreeNode x) {
        TreeNode y = this.root;
        while (y.right != null) {
            y = y.right;
        }
        transplant(y,y.left);

        if (x != y) {
            y.left = x.left;
            if (x.left != null) {
                x.left.parent = y;
            }
            y.right = x.right;
            if (x.right != null) {
                x.right.parent = y;
            }
        }
        transplant(x,y);
    }

    @Override
    public void transplant(TreeNode y, TreeNode w) {
        TreeNode v = y.parent;
        if (y != this.root) {
            if (y == v.right) {
                v.right = w;
            } else {
                v.left = w;
            }
        } else {
            this.root = w;
        }
        if (w != null) {
            w.parent = v;
        }
    }
}
