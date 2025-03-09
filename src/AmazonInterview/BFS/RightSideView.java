package AmazonInterview.BFS;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            int level =  0;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if(current == null) continue;
                level = current.val;
                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
            }
            ans.add(level);
        }
        return ans;
    }
}
