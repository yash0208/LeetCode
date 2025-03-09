package AmazonInterview.BinaryTree;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerializeDeserialized {
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        buildString(root, res);
        return String.join(",", res);
    }

    private void buildString(TreeNode node, List<String> res) {
        if (node == null) {
            res.add("N");
        } else {
            res.add(String.valueOf(node.val));
            buildString(node.left, res);
            buildString(node.right, res);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodeValues = data.split(",");
        index = 0;
        return buildTree(nodeValues);
    }

    private int index;
    private TreeNode buildTree(String[] nodeValues) {
        if (nodeValues[index].equals("N")) {
            index++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodeValues[index]));
        index++;
        node.left = buildTree(nodeValues);
        node.right = buildTree(nodeValues);
        return node;
    }
}
