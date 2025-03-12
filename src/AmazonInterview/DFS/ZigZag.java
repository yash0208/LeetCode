package AmazonInterview.DFS;

import java.util.Map;

public class ZigZag {
    int maxZigZag = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;

        dfs(root.left, 1, 1);  // Left move
        dfs(root.right, 2, 1); // Right move

        return maxZigZag;
    }

    private void dfs(TreeNode node, int direction, int length) {
        if (node == null) return;

        maxZigZag = Math.max(maxZigZag, length);

        if (direction == 1) {  // Last move was left, move right next
            dfs(node.right, 2, length + 1);
            dfs(node.left, 1, 1);  // Restart from left
        } else {  // Last move was right, move left next
            dfs(node.left, 1, length + 1);
            dfs(node.right, 2, 1); // Restart from right
        }
    }
}
