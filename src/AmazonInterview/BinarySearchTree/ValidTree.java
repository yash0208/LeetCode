package AmazonInterview.BinarySearchTree;

public class ValidTree {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    boolean isValid(TreeNode root,long min,long max){
        if(root == null) return true;
        if(root.val<=min || root.val>=max) return false;
        return isValid(root.left,min,root.val) && isValid(root.right,root.val,max);
    }
}
