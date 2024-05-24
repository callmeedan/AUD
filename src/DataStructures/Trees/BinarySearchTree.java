package DataStructures.Trees;

public class BinarySearchTree implements Tree {
    private TreeNode root;
    public BinarySearchTree() {
        this.root = null;
    }

    public void bstInorder() {
        inorder(root);
    }

    public void bstPreorder() {
        preorder(root);
    }

    public void bstPostorder() {
        postorder(root);
    }

    @Override
    public TreeNode search(TreeNode root, int k) {
        if (root == null || root.val == k) return root;
        if (root.val > k) return search(root.left, k);
        else return search(root.right, k);
    }

    public TreeNode bstSearch(int k) {
        return search(root, k);
    }

    @Override
    public void insert(TreeNode z) {
        TreeNode x = this.root;
        TreeNode px = null;
        while (x != null) {
            px = x;
            if (x.val > z.val) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.parent = px;
        if (px == null) {
            this.root = z;
        } else {
            if (px.val > z.val) {
                px.left = z;
            } else {
                px.right = z;
            }
        }
    }

    @Override
    public void delete(TreeNode z) {
        TreeNode y;
        if (z.left == null) {
            transplant(z, z.right);
        } else {
            if (z.right == null) {
                transplant(z, z.left);
            } else {
                y = z.right;
                while (y.left != null) {
                    y = y.left;
                }
                if (y.parent != z) {
                    transplant(y, y.right);
                    y.right = z.right;
                    y.right.parent = y.parent;
                }
                transplant(z,y);
                y.left = z.left;
                y.left.parent = y;
            }
        }
    }

    @Override
    public void transplant(TreeNode u, TreeNode v) {
        if (u.parent == null) {
            this.root = v;
        } else {
            if (u == u.parent.left) {
                u.parent.left = v;
            } else {
                u.parent.right = v;
            }
        }
        if (v != null) {
            v.parent = u.parent;
        }
    }
}
