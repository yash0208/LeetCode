package AmazonInterview.BinarySearchTree;

public class InsertInBinaryTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val); // Base case: Insert new node

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val); // Recurse into left subtree
        } else if (val > root.val) {
            root.right = insertIntoBST(root.right, val); // Recurse into right subtree
        }

        return root; // Return updated root
    }
}
