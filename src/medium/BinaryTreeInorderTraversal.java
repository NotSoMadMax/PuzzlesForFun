package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class BinaryTreeInorderTraversal {
	private static void searchLeft(TreeNode root, Stack<TreeNode> s){
		TreeNode cur = root;
		s.add(root);
		while(cur.left != null){
			cur = cur.left;
			s.add(cur);
		}
					
		return;
	}
	
    private static List<Integer> inorderTraversal(TreeNode root) {
        if(root == null)
        		return Collections.emptyList();
        
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        searchLeft(root, s);
        
        while(!s.isEmpty()){
        		TreeNode cur = s.pop();
        		result.add(cur.val);
        		if(cur.right != null)
        			searchLeft(cur.right, s);
        }
                
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
