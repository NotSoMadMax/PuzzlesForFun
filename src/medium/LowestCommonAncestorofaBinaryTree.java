package medium;

public class LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;

        if(root == p || root == q)
            return root;

        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        if(l != null && r != null)  // p and q in left and right trees accordingly
            return root;
        else if(r == null)  // both in left tree
            return l;
        else           // both in right tree
            return r;
    }
}
