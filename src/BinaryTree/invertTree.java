package BinaryTree;

import com.sun.source.tree.Tree;

public class invertTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        if (root.left == null && root.right == null) return root;
        else {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        if(root.right == null) invertTree(root.left);
        else if(root.left == null) invertTree(root.right);
        else {
            invertTree(root.left);
            invertTree(root.right);
        }
        return  root;

//        Optimized
//        if(root==null){
//            return root;
//        }
//
//        TreeNode lft = invertTree(root.left);
//        TreeNode rt = invertTree(root.right);
//
//        root.left = rt;
//        root.right = lft;
//
//        return root;

    }

}
