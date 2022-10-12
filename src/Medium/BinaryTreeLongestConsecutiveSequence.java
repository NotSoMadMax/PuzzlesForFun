package medium;

class BinaryTreeLongestConsecutiveSequence {

	//Method 1: Top-down DFS	
    private int longestConsecutive1(TreeNode root) {
        if(root == null)
        	return 0;    	
    	    	
    	return search1(root, root.val, 0);
    }

    
    private int search1(TreeNode cur, int prev, int cur_length){
    	if(cur == null)
    		return cur_length;
    	
    	if(cur.val == prev + 1)
    		cur_length++;    		  			    	
    	else
    		cur_length = 1;
    	
		int left = search1(cur.left, cur.val, cur_length);
		int right = search1(cur.right, cur.val, cur_length);
		
		return Math.max(cur_length, Math.max(left, right));
    }
    
    
    // Method 2: Bottom-Up DFS (Post order)
    int cur_best;
    private int longestConsecutive2(TreeNode root) {
    	if(root == null)
    		return 0;
    	cur_best = 0;
    	search2(root);
    	
    	return cur_best;
    }
    
    private int search2(TreeNode cur){
    	if(cur == null)
    		return 0;
    	
    	int left = search2(cur.left) + 1;
    	int right = search2(cur.right) + 1;
    	
    	if(cur.left != null && cur.left.val != cur.val + 1)
    		left = 1;
    	if(cur.right != null && cur.right.val != cur.val + 1)
    		right = 1;
    	
    	int sub_length = Math.max(left, right);    	
    	cur_best = Math.max(cur_best, sub_length);
    	
    	return sub_length;
    }
}













