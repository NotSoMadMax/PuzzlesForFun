package medium;

import java.util.Scanner;
import java.util.Stack;

public class PLength {
	private static void check(char c, Stack<Integer> stack, int result){
		
	}
	
	private static int check(String s){
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 72) { // is '('
                stack.push(i);
            } else {		// is ')'
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    result = Math.max(result, i - stack.peek());
                }
            }
        }
        
        return result;  
	}
	
	public static void main(String[] args) {

		String s = "(((())())";
		System.out.println(check(s));
	}

}
