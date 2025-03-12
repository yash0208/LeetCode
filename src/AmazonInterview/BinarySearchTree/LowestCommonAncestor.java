package AmazonInterview.BinarySearchTree;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if(root == null || root == p || root == q) return root;
       TreeNode left = lowestCommonAncestor2(root.left,p , q );
       TreeNode right = lowestCommonAncestor2(root.right, p , q);
       if (left!=null && right!=null) return root;
       return left == null? right : left;
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
