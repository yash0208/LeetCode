package AmazonInterview.DFS;

import java.util.Arrays;
import java.util.HashMap;

public class ConsrtuctBinaryTree {
    //preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;

        TreeNode node = new TreeNode(preorder[0]);
        if (preorder.length == 1) return node;

        // Find the index of root in inorder array
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                rootIndex = i;
                break;
            }
        }

        // Left and right subtree slices
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, rootIndex + 1);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] rightPreorder = Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);

        // Recursively construct left and right subtrees
        node.left = buildTree(leftPreorder, leftInorder);
        node.right = buildTree(rightPreorder, rightInorder);

        return node;
    }

}
