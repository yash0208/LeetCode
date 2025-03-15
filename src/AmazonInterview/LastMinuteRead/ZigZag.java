package AmazonInterview.LastMinuteRead;

import BinaryTree.TreeNode;

import java.util.Map;

public class ZigZag {
    int max = 0;
    public int longestZigZag(TreeNode root) {
        //we need to find the zig zag so we can go to left and right and try to find max zigzag
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        zigZag(root.left,1,true);
        zigZag(root.right,1,false);
        return max;
    }
    //dfs to find zigzag
    void zigZag(TreeNode root, int length, boolean isToLeft){
        if(root == null) return;
        max = Math.max(length + 1 , max);
        if(isToLeft){
            zigZag(root.right,length + 1,!isToLeft);
            zigZag(root.left,length,isToLeft);
        }
       else{
            zigZag(root.right,length,!isToLeft);
            zigZag(root.left,length + 1,isToLeft);
        }
    }
}
