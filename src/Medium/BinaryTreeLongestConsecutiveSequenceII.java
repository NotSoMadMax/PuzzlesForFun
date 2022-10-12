package medium;

class BinaryTreeLongestConsecutiveSequenceII {
	int best;
	
    private int longestConsecutive(TreeNode root) {
        if(root == null)
        	return 0;
        best = 1;
        
        search(root);
        return best;
    }
    
    private int[] search(TreeNode root){
    	if(root == null)
    		return new int[]{0, 0};
    	
    	int[] dec_inc = new int[]{1, 1};
    	int[] l = search(root.left);
    	int[] r = search(root.right);
    	
    	if(root.left != null){
    		if(root.val == root.left.val + 1)
    			dec_inc[0] += l[0];
    		if(root.val == root.left.val - 1)
    			dec_inc[1] += l[1];
    	}
    		
    	if(root.right != null){
    		if(root.val == root.right.val + 1)
    			dec_inc[0] = Math.max(dec_inc[0], 1 + r[0]);
    		if(root.val == root.right.val - 1)
    			dec_inc[1] = Math.max(dec_inc[1], 1 + r[1]);
    	}
    	
    	best = Math.max(best,  dec_inc[0] + dec_inc[1] - 1);
    			
    	return dec_inc;
    }
}
