package BinarySearchTree.Traversal;

import BinaryTree.TreeNode;
import com.sun.source.tree.Tree;

public class Inorder {
    public void inorder(TreeNode root){
        if(root == null) return;
        if(root.left != null) inorder(root.left);
        System.out.println(root.val);
        if(root.right != null) inorder(root.right);
    }
}
