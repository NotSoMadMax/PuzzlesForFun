package Easy;

import java.util.LinkedList;
import java.util.Queue;

class MinimumDepthofBinaryTree {

	class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
      	  this.val = val;
      	  this.left = left;
      	  this.right = right;
      }
  	}

	//calculate all node, slow
	/*
    private int minDepth(TreeNode root) {
        if(root == null)	return 0;
        
        if (root.left == null && root.right == null)
        	return 1;
        
        return helper(root);
    }
    
   
    private static int helper(TreeNode root){
    	if (root == null)	return Integer.MAX_VALUE;	// if one child is null, it shouldn't count
    	
    	if (root.left == null && root.right == null)
    		return 1;
    	
    	int left_depth = helper(root.left);    	
    	
    	int right_depth = helper(root.right);    
    	
    	return 1 + Math.min(left_depth, right_depth);
    }
    */

	// Method 1: DFS
    private int minDepthDFS(TreeNode root) {
    	if (root == null)
    		return 0;
    	
    	int left_depth = minDepthDFS(root.left);
    	int right_depth = minDepthDFS(root.right);
    	
    	if(left_depth == 0 || right_depth == 0){	// if one child is null, doesn't count
    		return 1 + Math.max(left_depth, right_depth);
    	}
    	
    	return 1 + Math.min(left_depth, right_depth);
    }

    // Method 2: BFS
	// Score: 100%
	private int minDepthBFS(TreeNode root) {
    	if (root == null) {
    		return 0;
		}

		Queue<TreeNode> queue = new LinkedList<>();
    	queue.add(root);

    	int depth = 0;
		TreeNode cur;
    	while (!queue.isEmpty()) {
    		int nOfNodes = queue.size(); // Number of nodes at this level
			for (int i = 0; i < nOfNodes; i++) {
				cur = queue.poll();
				if (cur.left == null && cur.right == null) {	// return when reached the first leaf
					return depth;
				}
				if (cur.left != null) {
					queue.add(cur.left);
				}
				if (cur.right != null) {
					queue.add(cur.right);
				}
			}
			depth++;
		}
    	return depth;
	}
}







