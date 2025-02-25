package Graph.Traversal.LeetCode.BSF;

import BinaryTree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Class to compute the average value of nodes at each level in a binary tree.
 *
 * <p>This class implements a BFS (level-order traversal) approach to calculate
 * the average of node values at each depth of the binary tree.
 *
 * <p>Time Complexity: O(N), where N is the number of nodes in the tree.
 * <p>Space Complexity: O(N), due to the queue used for level-order traversal.
 */
class averageOfLevels {

    /**
     * Computes the average value of nodes at each level of the binary tree.
     *
     * <p>The function performs a level-order traversal and calculates the
     * mean value of all nodes at each depth.
     *
     * @param root The root node of the binary tree.
     * @return A list of doubles representing the average node values at each level.
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if (root == null) return ans; // Handle edge case of an empty tree.

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // Perform level-order traversal
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;

            // Process all nodes at the current level
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                sum += current.val; // Accumulate sum of values at this level

                // Add child nodes to queue
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }

            // Compute the average and add to the result list
            ans.add(sum / size);
        }
        return ans;
    }
}
