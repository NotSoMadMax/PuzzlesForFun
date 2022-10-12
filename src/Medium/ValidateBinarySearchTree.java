package medium;

public class ValidateBinarySearchTree {
	
	private static boolean isValidBST(TreeNode root) {
        if (root == null)
        		return true;
        
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
	
	private static boolean check(TreeNode root, long min, long max){
		if (root == null)
			return true;
				
		if(root.val <= min || root.val >= max) 
			return false;
		
		boolean leftTree = check(root.left, min, root.val);			
		boolean rightTree = check(root.right, root.val, max);
		
		return leftTree && rightTree;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
