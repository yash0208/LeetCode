package Trees.DFS;

/**
 * Base case if root is null return 0
 * if not return 1+max(depth(left),depth(right))
 *
 */
class MaximumDepth {
    public int maxDepth(TreeNode root) {
        //Recursion
        if(root==null) return 0;
        else return  1 + Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}