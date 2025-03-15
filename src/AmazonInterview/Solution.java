package AmazonInterview;

import BinaryTree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.*;

public class Solution{
    public int longestZigZag(TreeNode root) {
        calculateSum(root,root.val);
        return ans;
    }
    int ans = 0;
    int calculateSum(TreeNode root, int previousSum){
        if(root == null) return previousSum;
        if(root.left != null) calculateSum(root.left, previousSum + root.val);
        if(root.right != null) calculateSum(root.right, previousSum + root.val);
        return 0;
    }
}