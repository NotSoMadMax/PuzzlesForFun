package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PathSumII {
    private List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
        	return Collections.emptyList();
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> answer = new ArrayList<Integer>();
        
        helper(root, sum, answer, result);
        
        return result;
    }
    
    private static void helper(TreeNode root, int sum, ArrayList<Integer> answer, List<List<Integer>> result){
    	if (root == null)	return;
    	
    	answer.add(root.val);
    	
    	if (root.left == null && root.right == null && root.val == sum){    		
    		result.add(new ArrayList<>(answer));	// create a new list instead of directly putting it into    	
    		answer.remove(answer.size() - 1);
    		return;
    	}
    	
    	helper(root.left, sum - root.val, answer, result);
    	helper(root.right, sum - root.val, answer, result);
    	
    	answer.remove(answer.size() - 1);
    	return;
    }
}





