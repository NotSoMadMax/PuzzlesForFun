package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class PrefixToPostfix {
	
    static private boolean isOperator(char c){
        if (42 <= c && c <= 47)
            return true;
        else
            return false;
    }
	
    static String[] prefixToPostfix(String[] prefixes) {
        int len = prefixes.length;
        if (len < 1 || prefixes == null)
            return prefixes;
        
        String[] ans = new String[len];
        for (int i = 0; i < len; i++){
        		ans[i] = "";
        }
        
        Stack<String> s = new Stack<>();
        for (int cur = 0; cur < len; cur++){        		
        		int n = prefixes[cur].length();
        		for (int i = n - 1; i >= 0; i--){
        			String c = "" + prefixes[cur].charAt(i);
        			if (!isOperator(prefixes[cur].charAt(i))){	// if this is an operand, push into stack
        				s.push(c);
        			} else {				// if this is an operator
        				String t1 = s.pop();
        				String t2 = s.pop();
        				s.push(t1 + t2 + c);
        			}
        		}
        		
        		while(!s.isEmpty()){
        			ans[cur] += s.pop();
        		}
        }
    		
    		return ans;
    }
    
    public static void main(String[] args){
    		System.out.println();
    }
}
