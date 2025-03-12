package AmazonInterview.BackTracking;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> strings = new ArrayList<>();
        helper(root, "", strings);
        return strings;
    }

    void helper(TreeNode root, String path, List<String> strings) {
        if (root == null) return;

        // Append current node's value to the path
        path += root.val;

        // If it's a leaf node, add the path to the result
        if (root.left == null && root.right == null) {
            strings.add(path);
        } else {
            // Add '->' to indicate path continuation
            path += "->";

            // Recursively explore the left and right subtrees
            if (root.left != null) helper(root.left, path, strings);
            if (root.right != null) helper(root.right, path, strings);
        }
    }
}

//Course schedule
//Detect A Cycle In Graph
