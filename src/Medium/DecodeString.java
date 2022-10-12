package medium;

import java.util.Stack;

class DecodeString {
	// Method 2: Stack
	private String decodeString2(String s) {
    	if(s == null || s.isEmpty())
    		return s;
    	
    	Stack<Integer> repeat = new Stack<>();
    	Stack<String> sub = new Stack<>();
    	char[] sc = s.toCharArray();
    	
    	String res = "";
    	for(int i = 0; i < s.length();)
    	{
    		if(Character.isLetter(sc[i]))
    			res += sc[i++];
    		else if(Character.isDigit(sc[i]))
    		{
    			int n_rep = 0;
    			while(Character.isDigit(sc[i]))
    				n_rep = 10*n_rep + (sc[i++] - '0');
    			repeat.push(n_rep);    			    			
    		}
    		else if(sc[i] == '[')
    		{
    			sub.push(res);
    			res = "";
    			i++;
    		}
    		else if(sc[i] == ']')
    		{
    			int n_rep = repeat.pop();
    			//System.out.println(n_rep);
    			String ans = sub.pop();
    			for(int j = 0; j < n_rep; j++)
    				ans += res;  
    			
    			res = ans;
    			i++;
    		}
    		else
    			i++;
    	}
    	
    	return res;
	}
		
	// Method 1: Recursion
    private String decodeString1(String s) {
    	if(s == null || s.isEmpty())
    		return s;
    	
        return decode(s.toCharArray(), 0, s.length());
    }
    
    private String decode(char[] s, int start, int end){
    	if(start >= end)
    		return "";
    	
    	String ans = "";
    	for(int i = start; i < end;)
    	{
    		if(Character.isLetter(s[i]))
    			ans += s[i++];
    		else if(Character.isDigit(s[i]))
    		{
    			int repeat = 0;
                while (Character.isDigit(s[i])) 
                    repeat = repeat * 10 + s[i++] - '0';
                    			
    			int count = 1;
    			int sub_start = i;
    			i = i + 1;
    			
    			while(count != 0)
    			{
    				if(s[i] == '[')
    					count++;
    				if(s[i] == ']')
    					count--;
    				i++;
    			}
    			String sub_string = decode(s, sub_start, i);
    			for(int j = 0; j < repeat; j++)
    				ans += sub_string;
    		}
    		else
    			i++;
    	}
    	
    	return ans;
    }
}
