package Hard;

import java.util.Stack;

public class BasicCalculator {
    private int calculate(String s) {
        if(s == null || s.isEmpty())
        	return 0;
        
        int res = 0;
        int num = 0; // current number
        int sign = 1;	// sign before current number
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
        	if(c >= '0' && c <= '9'){
        		num = num*10 + (c - '0'); 
        	}
        	else if(c == '-' || c == '+'){
				res += sign*num;
				num = 0;
				sign =  c == '+'?1:-1;
			}
        	else if (c == '(') {
				stack.push(res);
				stack.push(sign);
				res = 0;
				sign = 1;
			}
        	else if(c == ')') {
				res += sign*num;
				res *= stack.pop();
				res += stack.pop();
				num = 0;
			}
		}
        
        res += sign*num;	// when last char is a num
        return res;
    }
}
