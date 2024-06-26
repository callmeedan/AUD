package DataStructures.Trees;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    NodeColor color;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}
