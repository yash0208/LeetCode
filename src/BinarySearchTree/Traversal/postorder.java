package BinarySearchTree.Traversal;

import BinaryTree.TreeNode;

public class postorder {
    public void postorder(TreeNode root){
        if(root == null) return;
        System.out.println(root.val);
        if(root.right != null) postorder(root.right);
        if(root.left != null) postorder(root.left);
    }
}
