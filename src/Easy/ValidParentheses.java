package Easy;

import java.util.Stack;

public class ValidParentheses {
	
    private static boolean isValid(String s) {
    	int len = s.length();
    	if (len == 0 || len % 2 != 0)
    		return false;
    	
    	Stack<Character> stack = new Stack<Character>();
    	char[] cs = s.toCharArray();
    	for (int i = 0; i < len; i++){
    		char c = cs[i];
    		if (c == '(')
    			stack.push(')');
    		else if (c == '{')
    			stack.push('}');
    		else if (c == '[')
    			stack.push(']');
    		else if (stack.isEmpty() || stack.pop() != c)
    			return false;
    	}
    	
    	if (stack.isEmpty())
            return true;
        else
            return false;
    }
    
    public static void main(String args[]){
    	//String s = "[{])(}";
    	String s = "[{}]";
    	System.out.println(isValid(s));
    	
    	return;
    }
}
