package Easy;

class PathSum {
	
	// dfs all path, deduct from sum at each level
	/*
	private boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
        	return false;
        
        if (root.left == null && root.right == null && root.val == sum)	// if is a leaf
        	return true;                        
        
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
	*/
	
	
	// Similar speed
	private boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
        	return false;
        
        if (root.left == null && root.right == null && root.val == sum)	// if is a leaf
        	return true;                        
        
        boolean left = false;
        if (root.left != null)
        	left = hasPathSum(root.left, sum - root.val);
        
        boolean right = false;
        if (root.right != null)
        	right = hasPathSum(root.right, sum - root.val);
        
        return left||right;
	}
	
}
