package Trees.DFS;

public class PrintTree {
    public void print(TreeNode treeNode){
        if(treeNode==null) return;
        print(treeNode.left);
        System.out.print(treeNode.val+" ");
        print(treeNode.right);
    }
}
