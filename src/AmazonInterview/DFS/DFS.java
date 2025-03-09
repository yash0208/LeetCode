package AmazonInterview.DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFS {
    public static Node<Integer> dfs(Node<Integer> root, int target) {
        if (root == null) {
            return null;
        }
        if (root.val == target) {
            return root;
        }
        // return non-null return value from the recursive calls
        Node left = dfs(root.left, target);
        if (left != null) {
            return left;
        }
        // at this point, we know left is null, and right could be null or non-null
        // we return right child's recursive call result directly because
        // - if it's non-null we should return it
        // - if it's null, then both left and right are null, we want to return null
        return dfs(root.right, target);
    }

    public static Node<Integer> dfsNonRecursion(Node<Integer> root, int target) {
        if (root == null) return null;

        Stack<Node<Integer>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node<Integer> current = stack.pop();

            if (current.val == target) return current;

            // Push right child first so left is processed first (Preorder: Root -> Left -> Right)
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }

        return null; // Target not found
    }

}
