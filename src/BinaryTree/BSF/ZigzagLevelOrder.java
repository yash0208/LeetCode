package BinaryTree.BSF;

import BinaryTree.TreeNode;
import java.util.*;

/**
 * Class to perform Zigzag Level Order Traversal of a binary tree.
 *
 * <p>This class implements a modified BFS (Breadth-First Search) approach
 * to traverse a binary tree in a zigzag pattern.
 *
 * <p>In zigzag traversal:
 * - Nodes at odd levels (1st, 3rd, ...) are traversed left to right.
 * - Nodes at even levels (2nd, 4th, ...) are traversed right to left.
 *
 * <p>Time Complexity: O(N), where N is the number of nodes in the tree.
 * <p>Space Complexity: O(N), due to the queue and result storage.
 */
public class ZigzagLevelOrder {

    /**
     * Performs a zigzag level-order traversal (BFS) of a binary tree.
     *
     * <p>The method processes each level separately and reverses the node order
     * for alternate levels to achieve a zigzag pattern.
     *
     * @param root The root node of the binary tree.
     * @return A list of lists, where each inner list represents a level of the tree.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans; // Handle edge case of an empty tree.

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1; // Track level number (odd/even for zigzag order)

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            // Process all nodes at the current level
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                list.add(current.val); // Store the current node's value

                // Add child nodes to the queue for next level
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }

            // Reverse the order for even levels
            if (level % 2 == 0) list = reverse(list);

            ans.add(list);
            level++; // Increment level count
        }
        return ans;
    }

    /**
     * Reverses a list of integers.
     *
     * @param list The list to be reversed.
     * @return A new list with elements in reverse order.
     */
    private List<Integer> reverse(List<Integer> list) {
        List<Integer> ans = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            ans.add(list.get(i));
        }
        return ans;
    }
}
