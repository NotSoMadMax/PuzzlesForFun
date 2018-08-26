package Easy;

class BalancedBinaryTree {
	
	// find depth of subtrees node by node, slow
    /*private static boolean isBalanced(TreeNode root) {
        if (root == null)
        	return true;
        
        int left_depth = depth(root.left);
        int right_depth = depth(root.right);
            	
    	if (Math.abs(left_depth - right_depth)>1) return false;
    	
    	return isBalanced(root.left) && isBalanced(root.right);
    }
    
    
    private static int depth(TreeNode root){
    	if (root == null)
    		return 0;
    	
    	return 1 + Math.max(depth(root.left), depth(root.right));
    }
    */
    
	// stop when finding non-equal node, faster
    private static boolean isBalanced(TreeNode root) {
    	if(root == null) return true;
    	
    	return helper(root) != -1;
    }
    
    
    private static int helper(TreeNode root){
    	if (root == null) return 0;
    	
    	int left_depth = helper(root.left);
    	if (left_depth == -1)	return -1;
    	
    	int right_depth = helper(root.right);
    	if(right_depth == -1)	return -1;
    	
    	if (Math.abs(left_depth - right_depth) > 1)	return -1;
    	
    	return 1 + Math.max(left_depth, right_depth);
    }
    
}
