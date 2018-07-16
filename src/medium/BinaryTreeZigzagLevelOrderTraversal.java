package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
		
		if(level % 2 == 1){
			result.get(level-1).add(cur_node.val);
		} else {
			result.get(level-1).add(0, cur_node.val);
		}
		
		recursor(cur_node.left, level+1, result);
		recursor(cur_node.right, level+1, result);
		
	}
}
