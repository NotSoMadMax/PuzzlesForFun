package medium;

class InorderSuccessorinBST {
	
	// if there's a node larger than p, there is a successor
    private TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null)
        	return null;
        
        if(root.val <= p.val)
        	return inorderSuccessor(root.right, p);
        else
        {
        	TreeNode left = inorderSuccessor(root.left, p);
        	return left == null?root:left;
        }
    }
}
