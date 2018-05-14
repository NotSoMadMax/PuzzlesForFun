package medium;

public class DecodeWays {
    static private int numDecodings(String s) {
    		if (s == null || s.length() < 1)
    			return 0;
    		
    		char[] c = s.toCharArray();
    		int len = c.length;
    		if (c[0] == '0')
    			return 0;
    		
    		if(c[len - 1] == '0' && c[len - 2] - '0' > 2)
    			return 0;
    		
    		int num2 = 1, num1 = 1, cur = 1; 			
    		
    		for(int i = 1; i < len; i++){    	
    			
    			if(c[i] == '0'){
    				if (c[i-1] == '1' || c[i-1] == '2')
    					cur = num2;
    				else
    					return 0;
    			} 
    			else {
    				int cur_num = (c[i-1]-'0')*10 + (c[i] - '0');
    				
        			if ((cur_num < 10 && cur_num > 0) || (cur_num > 26)) 
        				cur = num1;
        			else if ((cur_num > 10 && cur_num < 20) || (cur_num > 20 && cur_num < 27))
        				cur = num1 + num2;
    			}    			    			
    			
    			num2 = num1;
    			num1 = cur;
    		}
    		
    		return cur;
    }
    
    public static void main(String args[]){
    		String s = "10";
    		System.out.println(numDecodings(s));
    }
}
