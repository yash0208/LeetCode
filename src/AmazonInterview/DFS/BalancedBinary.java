package AmazonInterview.DFS;



public class BalancedBinary {
    public boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1;  // If it returns -1, the tree is unbalanced
    }

    // Helper function to check balance and compute height
    private int checkBalance(TreeNode node) {
        if (node == null) return 0;  // A null node is balanced with height 0

        // Recursively check the left and right subtrees
        int leftHeight = checkBalance(node.left);
        int rightHeight = checkBalance(node.right);

        // If left or right subtree is unbalanced, return -1
        if (leftHeight == -1 || rightHeight == -1) return -1;

        // If the current node is unbalanced, return -1
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        // Return the height of the current subtree
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
