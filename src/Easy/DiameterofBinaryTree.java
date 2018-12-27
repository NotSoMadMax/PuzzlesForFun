package Easy;


class DiameterofBinaryTree {
    private int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
        	return 0;
        
        int[] res = new int[1];
        
        search(root, res);
        return res[0];
    }
    
    private int search(TreeNode cur, int[] res){
    	if(cur == null)
    		return 0;
    	
    	int left = search(cur.left, res);
    	int right = search(cur.right, res);
    	    	   	
    	res[0] = Math.max(res[0], left + right + 1);
    	
    	return Math.max(left, right) + 1;
    }    
}
