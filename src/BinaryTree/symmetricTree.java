package BinaryTree;

public class symmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true; // A null tree is symmetric
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        return (t1.val == t2.val) // Compare values
                && isMirror(t1.left, t2.right) // Compare opposite children
                && isMirror(t1.right, t2.left);
    }
}
