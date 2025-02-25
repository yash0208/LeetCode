package Graph.Traversal.LeetCode.BSF;

import BinaryTree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Class to perform level-order traversal of a binary tree.
 *
 * <p>This class implements a BFS (Breadth-First Search) approach
 * to traverse a binary tree level by level.
 *
 * <p>Time Complexity: O(N), where N is the number of nodes in the tree.
 * <p>Space Complexity: O(N), due to the queue storing nodes at each level.
 */
class LevelOrderTraversal {

    /**
     * Performs a level-order traversal (BFS) of a binary tree.
     *
     * <p>The method processes each level separately and stores node values
     * as lists, representing different levels of the tree.
     *
     * @param root The root node of the binary tree.
     * @return A list of lists, where each inner list represents a level of the tree.
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans; // Handle edge case of an empty tree.

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // Perform level-order traversal
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            // Process all nodes at the current level
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                level.add(current.val); // Store the current node's value

                // Add child nodes to the queue for next level
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }

            ans.add(level); // Store the completed level in the result list
        }

        return ans;
    }
}
