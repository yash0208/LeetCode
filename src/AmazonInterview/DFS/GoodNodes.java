package AmazonInterview.DFS;

import com.sun.source.tree.Tree;

public class GoodNodes {
    public int goodNodes(TreeNode root) {
        return isGoodNode(root,root.val,0);
    }

    int isGoodNode(TreeNode root, int max, int count){
        if(root == null) return 0;
        if(root.val >= max) {
            count++;
            max = root.val;
        }
        return isGoodNode(root.left,max,count) + isGoodNode(root.right,max,count);
    }
}
