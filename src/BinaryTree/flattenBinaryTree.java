package BinaryTree;

public class flattenBinaryTree {
    TreeNode ans = new TreeNode(0);
    public void flatten(TreeNode root) {
        if(root == null) root = ans;
        ans.right = root;
        if (root.left != null) flatten(root.left);
        if (root.right != null) flatten(root.right);
    }
}
