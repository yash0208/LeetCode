package BinarySearchTree;

import BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeIterator {

    class BSTIterator {
        Queue<Integer> queue;
        public BSTIterator(TreeNode root) {
            queue = new LinkedList<>();
            inOrder(root);
        }

        public void inOrder(TreeNode root){
            if(root == null) return;
            inOrder(root.left);
            queue.add(root.val);
            inOrder(root.right);
        }

        public int next() {
            return queue.poll();
        }

        public boolean hasNext() {
            return queue.isEmpty();
        }
    }

}
