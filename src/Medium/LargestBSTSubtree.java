package medium;

// test
class Test{
	public Test(){
		return;
	}
	
	public void t1(){
		int[] a = new int[]{1, 2};
		t2(a);
		System.out.println(a[1]);
	}
	
	public void t2(int[] a){
		a[1] = 10;
	}
}


class LargestBSTSubtree {
	
	// Method 1: Brutal Force, DFS and check each node
	int best;
    private int largestBSTSubtree(TreeNode root) {
        if(root == null)
        	return 0;
        
        best = 1;
        search(root);
        
        return best;
    }
    
    private void search(TreeNode root){
    	if(root == null)
    		return;
    	
    	int count = check(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    	if(count != -1){
    		best = Math.max(best, count);
    		return;
    	}
    	search(root.left);
    	search(root.right);
    }
    
    private int check(TreeNode cur, int max, int min){
    	if(cur == null)
    		return 0;    	    	
    	
    	if(cur.val >= max || cur.val <= min)
    		return -1;
    	
    	int left =  check(cur.left, cur.val, min);
    	int right = check(cur.right, max, cur.val);
    	
    	if(left != -1 && right != -1)
    		return left + right + 1;
    	else
    		return -1;
    }
    
    
    // Method 2
    private int largestBSTSubtree2(TreeNode root) {
        if(root == null)
        	return 0;
        
        int[] bund_size = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 1};
        search2(root, bund_size);
        return bund_size[2];
    }
    
    // use int[] bound_size instead of int max, min, size. int[] is pass by reference
    private boolean search2(TreeNode cur, int[] bound_size){
    	if(cur == null)
    		return true;
    	
    	int[] left_bound = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
    	int[] right_bound = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
    	
    	boolean l = search2(cur.left, left_bound);
    	boolean r = search2(cur.right, right_bound);
    	
    	if(l && r)
    	{
    		if((cur.left == null || cur.val > left_bound[1]) && 
    				(cur.right == null || cur.val < right_bound[0]))
    		{    			
    			bound_size[0] = cur.left==null?cur.val:left_bound[0];    			
    			bound_size[1] = cur.right==null?cur.val:right_bound[1];
    			
    			bound_size[2] = left_bound[2] + right_bound[2] + 1;
    			return true;
    		}
    	}
    	
    	bound_size[2] = Math.max(left_bound[2], right_bound[2]);
    	return false;
    }        
    
    
    public static void main(String[] args){
    	Test t = new Test();
    	t.t1();
    }
}










