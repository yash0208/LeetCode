package BinarySearchTree;

import BinaryTree.TreeNode;

class ParentTreeNode {
      public int val;
      public ParentTreeNode parent, left, right;
}
public class InorderSuccessor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // we need to find the next successor of the value
        TreeNode ans = new TreeNode(-1);
        while (root != null){
            if(root.val > p.val) {
                ans = root;
                root = root.left;
            }
            else root = root.right;
        }
        return ans;
    }

    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        // we need to find the next successor of the value
        TreeNode ans = new TreeNode(-1);
        while (root != null){
            if(root.val > p.val) {
                root = root.left;
            }
            else {
                ans = root;
                root = root.right;
            }
        }
        return ans;
    }

    public ParentTreeNode inorderSuccessor2(ParentTreeNode node) {
        // here we need to find the suceessor for the parent node
        // cases are if the parent is bigger than return
        if (node == null) return null;

        // Case 1: If the node has a right child, the successor is the leftmost node in the right subtree.
        if (node.right != null) {
            ParentTreeNode current = node.right;
            while (current.left != null) {
                current = current.left;
            }
            return current;
        }
        // Case 2: If the node does not have a right child, the successor is one of the ancestors.
        ParentTreeNode parent = node.parent;
        while (parent != null && node == parent.right) {
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }
}
