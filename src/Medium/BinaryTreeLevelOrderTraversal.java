package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTreeLevelOrderTraversal {
	
	// iterative method
	/*
    private static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
        	return Collections.emptyList();
        
        List<List<Integer>> result = new ArrayList<>();        
        
        Queue<TreeNode> cur_level = new LinkedList<>();
        Queue<TreeNode> next_level = new LinkedList<>();
        
        cur_level.add(root);
        
        while(!cur_level.isEmpty()){
        	ArrayList<Integer> numbers = new ArrayList<>();
        	
        	while(!cur_level.isEmpty()){
        		TreeNode cur = cur_level.poll();
        		numbers.add(cur.val);
        		
        		if(cur.left != null)	
        			next_level.add(cur.left);
        		if(cur.right != null)
        			next_level.add(cur.right);
        	}
        	
        	result.add(numbers);
        	
        	while(!next_level.isEmpty()){
        		cur_level.add(next_level.poll());
        	}
        	
        }
        
        return result;
    }*/
	
	
	// recursive method
	private static List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null)
			return Collections.emptyList();
		
		List<List<Integer>> result = new ArrayList<>();
		recursor(root, 1, result);
		
		return result;
	}
	
	private static void recursor(TreeNode cur_node, int level, List<List<Integer>> result){
		if(cur_node == null)
			return;
		
		if(level > result.size())
			result.add(new ArrayList<>());
		
		result.get(level-1).add(cur_node.val);
		recursor(cur_node.left, level+1, result);
		recursor(cur_node.right, level+1, result);
		
	}
    
 
    
}



