package medium;

import java.util.*;

class FindDuplicateSubtrees {
    private List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if(root == null)
        	return Collections.emptyList();
        
        List<TreeNode> res = new ArrayList<>();
    	Map<String, Integer> count = new HashMap<>();
    	search(root, count, res);
    	
    	return res;
    }
    
    private String search(TreeNode cur, Map<String, Integer> count, List<TreeNode> res){
    	if(cur == null)
    		return "";
    	
    	String code = cur.val + "," + search(cur.left, count, res) + "," + search(cur.right, count, res);
    	count.put(code, count.getOrDefault(code, 0) + 1);
    	
    	if(count.get(code) == 2)
    		res.add(cur); 
    	return code;
    }
}
