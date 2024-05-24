package DataStructures.Trees;

public interface Tree {
    default void inorder(TreeNode node){
        if (node != null) {
            inorder(node.left);
            System.out.print(node.val + " ");
            inorder(node.right);
        }
    }
    default void preorder(TreeNode node){
        if (node != null) {
            System.out.print(node.val + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }
    default void postorder(TreeNode node){
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.val + " ");
        }
    }
    TreeNode search(TreeNode root,int k);
    void insert(TreeNode x);
    void delete(TreeNode x);
    void transplant(TreeNode y, TreeNode w);

}
