package AmazonInterview.BinaryTree;

import BinaryTree.TreeNode;

public class SumRootLeaf {
    int ans = 0;

    public int sumNumbers(TreeNode root) {
        recursion(root, 0);
        return ans;
    }
    void recursion(TreeNode root,int sum){
        if(root==null){
            return;
        }
        if(root.left == null && root.right == null){
            ans += ((sum*10) + root.val);
            return;
        }
        recursion(root.left, sum * 10 + root.val);
        recursion(root.right, sum * 10 + root.val);
    }
}
