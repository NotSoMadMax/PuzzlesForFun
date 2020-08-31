package Easy;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    private boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;

        return recursive(root.left, root.right);
    }

    // Method 1
    // recursive
    private boolean recursive(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null)
            return true;

        if((root1 == null && root2 != null) || (root1 != null && root2 == null))
            return false;

        if(root1.val != root2.val)
            return false;

        if(recursive(root1.left, root2.right) && recursive(root1.right, root2.left))
            return true;
        else
            return false;
    }

    // Method 2
    // iterative BFS
    private boolean iterative(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null)
            return true;
        
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        
        q1.add(root1);
        q2.add(root2);
        
        while(!q1.isEmpty() && !q2.isEmpty()){
        	TreeNode cur1 = q1.poll();
        	TreeNode cur2 = q2.poll();
        	
        	if(cur1 == null && cur2 == null)
        		continue;
        	
        	if((cur1 == null && cur2 != null) || (cur1 != null && cur2 == null))
        		return false;
        	
        	if(cur1.val != cur2.val)
        		return false;

        	// Add in symmetric order
        	q1.add(cur1.left);
        	q1.add(cur1.right);
        	
        	q2.add(cur2.right);
        	q2.add(cur2.left);
        }
        
        return true;
    }

}
