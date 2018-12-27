package Easy;

class SubtreeofAnotherTree {
    private boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t != null)
        	return false;
    	
    	return searh(s, t);
    }   
    
    private boolean searh(TreeNode s, TreeNode t){
    	if(s == null)
    		return false;
    	
    	if(check(s, t))
    		return true;
    	
    	boolean left = searh(s.left, t);
    	boolean right = searh(s.right, t);
    	
    	return left || right;
    }
    
    private boolean check(TreeNode s_cur, TreeNode t_cur){
    	if(s_cur == null && t_cur == null)
    		return true;
    	else if(s_cur == null || t_cur == null)
    		return false;
    	
    	if(s_cur.val != t_cur.val)
    		return false;
    	
    	return check(s_cur.left, t_cur.left) && check(s_cur.right, t_cur.right);
    }
}
