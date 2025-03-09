package AmazonInterview.BinarySearchTree;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;  // Base case

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root; // p and q found in different subtrees
        return left != null ? left : right; // Return non-null side
    }

    public TreeNode lowestCommonAncestor2(TreeNode root,TreeNode p,TreeNode q){
        if (root == null) {
            return null;
        }
        if (root == p) {
            return p;
        }
        if (root == q) {
            return q;
        }
        if (p.val <= root.val && root.val <= q.val) {
            return root;
        }
        if (q.val <= root.val && root.val <= p.val) {
            return root;
        }
        if (root.val > p.val) return lowestCommonAncestor2(root.left, p, q);
        else return lowestCommonAncestor2(root.right, p, q);
    }

}
