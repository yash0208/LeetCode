package BinarySearchTree;

import BinaryTree.TreeNode;

public class hasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        // If it's a leaf node, check if the sum matches
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // Recursive check on left and right subtrees
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);

    }
}
