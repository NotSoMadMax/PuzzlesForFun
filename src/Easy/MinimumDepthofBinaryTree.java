package Easy;

class MinimumDepthofBinaryTree {
	//calculate all node, slow
	/*
    private int minDepth(TreeNode root) {
        if(root == null)	return 0;
        
        if (root.left == null && root.right == null)
        	return 1;
        
        return helper(root);
    }
    
   
    private static int helper(TreeNode root){
    	if (root == null)	return Integer.MAX_VALUE;	// if one child is null, it shouldn't count
    	
    	if (root.left == null && root.right == null)
    		return 1;
    	
    	int left_depth = helper(root.left);    	
    	
    	int right_depth = helper(root.right);    
    	
    	return 1 + Math.min(left_depth, right_depth);
    }
    */
    
    private int minDepth(TreeNode root) {
    	if (root == null)
    		return 0;
    	
    	int left_depth = minDepth(root.left);
    	int right_depth = minDepth(root.right);
    	
    	if(left_depth == 0 || right_depth == 0){	// if one child is null, doesn't count
    		return 1 + Math.max(left_depth, right_depth);
    	}
    	
    	return 1 + Math.min(left_depth, right_depth);
    }
}
