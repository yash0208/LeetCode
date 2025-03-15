package AmazonInterview.LastMinuteRead;

import BinaryTree.TreeNode;

public class RootLeafSum {
        int sum = 0;
        public int sumNumbers(TreeNode root) {
            //here we need to make a dfs on both left and right to make the sum and combine them
            if(root == null) return 0;
            if(root.left == null && root.right == null) return root.val;
            sumCalc(root.left,root.val);
            sumCalc(root.right,root.val);
            return sum;
        }
        public void sumCalc(TreeNode root, int prefixSum){
            if (root == null){
                return;
            }
            int currentSum = (prefixSum * 10) + root.val;
            if(root.left == null && root.right == null) sum = sum + currentSum;
            if(root.left != null) sumCalc(root.left,currentSum);
            if(root.right != null) sumCalc(root.right,currentSum);
        }
}
