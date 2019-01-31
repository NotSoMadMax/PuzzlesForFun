package Hard;

class BasicCalculatorIII {
    private static int calculate(String s) {
        if(s == null || s.isEmpty())
        	return 0;
        
        int res = 0;
        int cur_res = 0; // used for a multiply/devision sequence
        int cur_num = 0;
        char operator = '+'; // the operator between current number and previous result
        
        for(int i = 0; i < s.length(); i++){
        	char cur = s.charAt(i);
        	
        	if(Character.isDigit(cur))
        	{
        		cur_num = cur_num*10 + cur - '0';
        	}
        	else if(cur == '(')
        	{
        		int start = i;
        		int count = 0;
        		for(; i < s.length(); i++){
        			if(s.charAt(i) == '(')
        				count++;
        			if(s.charAt(i) == ')')
        				count--;
        			if(count == 0)
        				break;
        		}
        		
        		cur_num = calculate(s.substring(start + 1, i));
        	}
        	
        	if(cur == '-' || cur == '+' || cur == '*' || cur == '/' || i == s.length() - 1)
        	{
        		if(operator == '+')
        			cur_res += cur_num;
        		else if(operator == '-')
        			cur_res -= cur_num;
        		else if(operator == '*')
        			cur_res *= cur_num;
        		else if(operator == '/')
        			cur_res /= cur_num;
        		
        		if(cur == '+' || cur == '-' || i == s.length() - 1){
        			res += cur_res;
        			cur_res = 0;
        		}
        		
        		operator = cur;
        		cur_num = 0;
        	}        	
        }
        
        return res;
    }
    
    
    public static void main(String[] args){
    	System.out.println(calculate("1 + 1"));
    }
}









