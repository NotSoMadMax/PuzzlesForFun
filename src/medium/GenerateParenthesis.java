package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateParenthesis {
	
    static private List<String> generateParenthesis(int n) {
    	if (n <= 0)
    		return Collections.emptyList();
    				
    	List<String> result = new ArrayList<>();
    	generate(n, n, "", result);
    	
        return result;
    }
    
    static private void generate(int left, int right, String out, List<String> result){
    	if (left < 0 || right < 0 || right < left)	return;
    	if (left == 0 && right == 0)
    		result.add(out);
    	
    	generate(left - 1, right, out + "(", result);
    	generate(left, right - 1, out + ")", result);
    }
    
    public static void main(String args[]){
    	int n = 3;
    	List<String> test = generateParenthesis(n);
    	for (String s : test)
    		System.out.println(s);    	
    	
    	return;
    }
}




