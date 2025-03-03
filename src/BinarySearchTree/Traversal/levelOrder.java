package BinarySearchTree.Traversal;

import BinaryTree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrder {
    public void levelOrder(TreeNode root){
        if(root == null) return;
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if(current.left != null) {
                    queue.add(current.left);
                }
                if(current.right != null) queue.add(current.right);
                level.add(current.val);
            }
            ans.add(level);
        }
    }
}
