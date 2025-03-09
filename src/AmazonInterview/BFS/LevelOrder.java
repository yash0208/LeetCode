package AmazonInterview.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> list = new ArrayList<>();
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level =  new ArrayList<>();
            for (int i = 0; i < size ; i++) {
                TreeNode current = queue.poll();
                if(current==null) continue;
                level.add(current.val);
                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
            }
            list.add(level);
        }
        return list;
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrderRecursion(TreeNode root) {
        traverse(root, 0);
        return res;
    }

    public void traverse(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }

        res.get(level).add(node.val);
        traverse(node.left, level+1);
        traverse(node.right, level+1);
    }
}
