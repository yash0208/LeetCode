package Graph.Traversal.LeetCode.BSF;

import BinaryTree.TreeNode;
import java.util.*;

/**
 * Solution class to compute the right-side view of a binary tree.
 *
 * <p>This class implements a BFS (level-order traversal) approach
 * to find the rightmost node at each level of the binary tree.
 *
 * <p>Time Complexity: O(N), where N is the number of nodes in the tree.
 * <p>Space Complexity: O(N), due to the queue used in level-order traversal.
 */
class rightSideView {

    /**
     * Returns the right-side view of a binary tree.
     *
     * <p>The right-side view consists of the last node seen at each depth
     * of the tree when looking from the right side.
     *
     * @param root The root node of the binary tree.
     * @return A list of integers representing the right-side view of the tree.
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans; // Handle edge case of an empty tree.

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // Perform level-order traversal
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode rightmost = null; // Store the rightmost node at each level

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                rightmost = current; // Update rightmost node in the level

                // Add child nodes to queue
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }

            // Add the last node (rightmost node) of this level to the result
            ans.add(rightmost.val);
        }

        return ans;
    }
}
