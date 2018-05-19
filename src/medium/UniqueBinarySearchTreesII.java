package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UniqueBinarySearchTreesII {
	
    private static List<TreeNode> generateTrees(int n) {
        if (n < 1)
        		return Collections.emptyList();
        
        List<TreeNode> result = subTree(1,  n);
        
        return result;        
    }
    
    private static List<TreeNode> subTree(int start, int end){
    		List<TreeNode> result = new ArrayList<>();
    		
    		if(start > end){
    			result.add(null);
    			return result;
    		}
    			
    		for (int i = start; i <= end; i++){	// for each root
    			List<TreeNode> leftTree = subTree(start, i-1);
    			List<TreeNode> rightTree = subTree(i+1, end);
    			for (int l = 0; l < leftTree.size(); l++){
    				for(int r = 0; r < rightTree.size(); r++){
    					TreeNode cur_root = new TreeNode(i);
    					cur_root.left = leftTree.get(l);
    					cur_root.right = rightTree.get(r);
    					result.add(cur_root);
    				}
    			}    			
    		}
    		
    		return result;
    }
    
	public static void main(String[] args) {		

	}

}




