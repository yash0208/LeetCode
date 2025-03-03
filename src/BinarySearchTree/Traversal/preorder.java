package BinarySearchTree.Traversal;

import BinaryTree.TreeNode;

public class preorder {
    public void preorder(TreeNode root){
        if(root == null) return;
        System.out.println(root.val);
        if(root.left != null) preorder(root.left);

        if(root.right != null) preorder(root.right);
    }
}
