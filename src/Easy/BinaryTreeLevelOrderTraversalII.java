package Easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTreeLevelOrderTraversalII {
    private List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null)
        	return Collections.emptyList();
                
        									//declare the type inside ArrayList<> can fasten the program
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();		// LinkedList is faster than ArrauQueue
        
        q.add(root);
        while(!q.isEmpty()){
        	List<Integer> this_level = new ArrayList<>();
        	int level_size = q.size();        	
        	
        	for(int i = 0; i < level_size; i++){
        		TreeNode cur = q.poll();
        		if(cur.left != null)	q.add(cur.left);
        		if(cur.right != null)	q.add(cur.right);
        		
        		this_level.add(cur.val);
        	}
        	result.add(0, this_level);
        }
        
        return result;
    }
}
