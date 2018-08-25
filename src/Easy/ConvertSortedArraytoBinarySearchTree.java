package Easy;

class ConvertSortedArraytoBinarySearchTree {
    private static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length < 1)
        	return null;

        return helper(nums, 0, nums.length - 1);
    }
    
    private static TreeNode helper(int[] nums, int start, int end){
    	if (start > end)
    		return null;
    	if (start == end)
    		return new TreeNode(nums[start]);
    	    	
    	int mid = start + (end - start)/2;
    	
    	TreeNode cur_root = new TreeNode(nums[mid]);
    	cur_root.left = helper(nums, start, mid - 1);
    	cur_root.right = helper(nums, mid + 1, end);
    	
    	return cur_root;
    }
    
    public static void main(String[] args){
    	int[] test = {0,1,2,3,4};
    	sortedArrayToBST(test);
    	
    	return;
    }
}
