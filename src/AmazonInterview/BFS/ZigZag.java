package AmazonInterview.BFS;

import java.util.*;

public class ZigZag {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new LinkedList<>();
        if (root == null) return list;
        queue.add(root);
        boolean flag = false;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if(current == null) continue;
                level.add(current.val);
                if(current.left != null) queue.add(current.left);
                if(current.right!=null) queue.add(current.right);
            }
            if(flag){
                Collections.reverse(level);
            }
            list.add(level);
            flag = !flag;
        }
        return list;
    }
}

