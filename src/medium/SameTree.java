package medium;

import java.util.Stack;

public class SameTree {
	
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
        		return true;
        
        if((p == null && q != null) || (p != null && q == null))
        		return false;
        
        Stack<TreeNode> t1 = new Stack<>();
        Stack<TreeNode> t2 = new Stack<>();
        
        t1.add(p);
        t2.add(q);        
        
        while(!t1.isEmpty() && !t2.isEmpty()){
        		TreeNode cur1 = t1.pop(), cur2 = t2.pop();
        				
            if(cur1.val != cur2.val)
            		return false;            
            
            if(cur1.left != null)            		
            		t1.add(cur1.left);            
            
            if(cur2.left != null)
            		t2.add(cur2.left);
            
            if(t1.size() != t2.size())
            		return false;
            
            if(cur1.right != null)
            		t1.add(cur1.right);
            
            if(cur2.right != null)
            		t2.add(cur2.right);
            
            if(t1.size() != t2.size())
        			return false;
            
        }
        
        return true;
    }
    
    
}
