package Hard;

import java.util.*;

class RemoveInvalidParentheses {
	
	// Method 1: Naive Backtracking
	int minim;	// minimum number of removal to generate a valid parenthese 
    private List<String> removeInvalidParentheses(String s) {
        if(s == null || s.isEmpty()){
        	List<String> t = new ArrayList<>();
        	t.add("");
        	return t;
        }
        
        minim = Integer.MAX_VALUE;
        HashSet<String> res = new HashSet<String>();        
        
        search(res, s, new StringBuilder(), 0, 0, 0, 0);
        
        return new ArrayList<>(res);
    }
    
    private void search(Set<String> res, String s, StringBuilder ans, int cur, int left_count, int right_count, int remov){
    	if(cur == s.length()){	// reach the end    		
    		if(left_count == right_count){	// is valid parentheses    			
    			if(remov < minim){	
    				res.clear();
    				minim = remov;
    				res.add(ans.toString());
    			} else if(remov == minim)
    				res.add(ans.toString());    			
    		}        		
    		return;
    	}
    	
    	// if not a bracket
    	if(s.charAt(cur) != ')' && s.charAt(cur) != '('){
    		ans.append(s.charAt(cur));
    		search(res, s, ans, cur + 1, left_count, right_count, remov);
    		ans.deleteCharAt(ans.length() - 1);
    		return;
    	}
    	 
    	// if is a bracket
		// option 1: remove current char
		search(res, s, ans, cur + 1, left_count, right_count, remov + 1);		
		
		// option 2: use current char
		ans.append(s.charAt(cur));
		if(s.charAt(cur) == '('){			
			search(res, s, ans, cur + 1, left_count + 1, right_count, remov);			
		}			
		else{
			if(right_count < left_count){				
				search(res, s, ans, cur + 1, left_count, right_count + 1, remov);				
			}				
		}				    		
	    	    	    	
		ans.deleteCharAt(ans.length() - 1);
    	return;
    }   
    
    
    // Method 2: Backtracking with pruning
    private List<String> removeInvalidParentheses2(String s) {
        if(s == null || s.isEmpty()){
        	List<String> t = new ArrayList<>();
        	t.add("");
        	return t;
        }
        
        Set<String> res = new HashSet<>();
        
        int left = 0, right = 0;	// num of left/right brackets to be removed
        for(int i = 0; i < s.length(); i++){
        	if(s.charAt(i) == '(')
        		left++;
        	else if(s.charAt(i) == ')'){
        		if(left == 0)
        			right++;
        		else        		
        			left--;        		
        	}
        }
        
        search2(res, s, new StringBuilder(), 0, 0, 0, left, right);
        
        return new ArrayList<>(res);
    }
    
    private void search2(Set<String> res, String s, StringBuilder ans, int cur, int left_count, int right_count, int left_rem, int right_rem){
    	if(cur == s.length()){
    		if(left_rem == 0 && right_rem == 0)
    			res.add(ans.toString());
    		return;
    	}
    	
    	// if not a bracket
    	if(s.charAt(cur) != ')' && s.charAt(cur) != '('){
    		ans.append(s.charAt(cur));
    		search2(res, s, ans, cur + 1, left_count, right_count, left_rem, right_rem);
    		ans.deleteCharAt(ans.length() - 1);
    		return;
    	}
    	
    	// option 1: remove current char
    	if(s.charAt(cur) == '(' && left_rem > 0)
    		search2(res, s, ans, cur + 1, left_count, right_count, left_rem - 1, right_rem);
    	if(s.charAt(cur) == ')' && right_rem > 0)
    		search2(res, s, ans, cur + 1, left_count, right_count, left_rem, right_rem - 1);
    	
    	// option 2: use current char
    	ans.append(s.charAt(cur));
    	if(s.charAt(cur) == '(')
    		search2(res, s, ans, cur + 1, left_count + 1, right_count, left_rem, right_rem);
    	if(s.charAt(cur) == ')'){
    		if(left_count > right_count)
    			search2(res, s, ans, cur + 1, left_count, right_count + 1, left_rem, right_rem);
    	}
    		    	
    	ans.deleteCharAt(ans.length() - 1);
    }
    
    
    public static void main(String[] args){
    	StringBuilder sb = new StringBuilder();
    	sb.append("01234");
    	System.out.println(sb.toString());
    	
    	sb.deleteCharAt(4);
    	System.out.println(sb.toString());
    }
}










