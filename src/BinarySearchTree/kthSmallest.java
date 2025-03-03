package BinarySearchTree;

import BinaryTree.TreeNode;

public class kthSmallest {
    class Solution {
        public int kthSmallest(TreeNode root, int k) {
            if(root == null) return 0;
            if(childCount(root) == k-1) return root.val;
            else if (childCount(root.left) > k-1) return kthSmallest(root.left,k);
            else return kthSmallest(root.right,k);
        }

        public int childCount(TreeNode root){
            if(root == null ) return 0;
            else if (root.right == null && root.left == null) return 0;
            else if (root.right == null) {
                return 1 + childCount(root.left);
            }
            else if(root.left == null){
                return 1 + childCount(root.right);
            }
            else {
                return 2 + childCount(root.right) + childCount(root.left);
            }
        }
    }
}
