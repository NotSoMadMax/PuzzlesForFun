package medium;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path.length() <= 1 || path == null)
        		return "";
        if (path == "/../")
        		return "/";

        // "/abc/..."
        String[] p = path.split("/");
        Stack<String> stack = new Stack<>();
                
        for(String s:p){
        		if (s.length() < 1)
        			continue;
        		
        		if (s.equals(".")){
        			continue;
        		} else if (s.equals("..")) {
        			if(!stack.isEmpty())
        				stack.pop();
        		} else {
        			stack.push(s);
        		}
        }
        
        if (stack.isEmpty())
        		return "/";
        
        String ans = "";
        while (!stack.isEmpty()){
        		ans = stack.pop() + "/" + ans ;
        }
        ans += "/";
        return ans.substring(0, ans.length() - 1);
    }
}



