package medium;

import java.util.*;

class SerializeandDeserializeBST {
	
	// Method 1: level by level
	public class Codec {

	    // Encodes a tree to a single string.
	    public String serialize(TreeNode root) {
	    	if(root == null)
	    		return "";
	    	
	        StringBuilder sb = new StringBuilder();
	        Queue<TreeNode> queue = new LinkedList<>();
	        
	        queue.add(root);
	        
	        while(!queue.isEmpty()){
	        	TreeNode cur = queue.poll();
	        	
	        	if(cur == null)
	        		sb.append("# ");
	        	else{
	        		sb.append(cur.val + " ");
	        		queue.add(cur.left);
	        		queue.add(cur.right);
	        	}
	        }
	    	
	    	return sb.toString();
	    }

	    // Decodes your encoded data to tree.
	    public TreeNode deserialize(String data) {
	    	if(data == null || data.isEmpty())
	    		return null;
	    	
	    	int i = 0;
	    	String[] nums = data.split(" ");
	    	Queue<TreeNode> queue = new LinkedList<>();
	    	
	    	TreeNode root = new TreeNode(Integer.valueOf(nums[i++]));	    	
	    	
	    	queue.add(root);
	    	
	    	while(!queue.isEmpty()){
	    		TreeNode cur = queue.poll();
	    		
	    		if(i >= nums.length)
	    			break;
	    		
	    		if(!nums[i].equals("#")){
	    			TreeNode treeNode = new TreeNode(Integer.valueOf(nums[i++]));
	    			cur.left = treeNode;
	    			queue.add(treeNode);
	    		}else
	    			i++;
	    		
	    		if(i >= nums.length)
	    			break;
	    		
	    		if(!nums[i].equals("#")){
	    			TreeNode treeNode = new TreeNode(Integer.valueOf(nums[i++]));
	    			cur.right = treeNode;
	    			queue.add(treeNode);
	    		}else
	    			i++;
	    			    		
	    	}
	    	
	        return root;
	    }
	}
}



















