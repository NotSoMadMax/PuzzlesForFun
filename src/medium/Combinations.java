package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Combinations {

	// iterative 79%
    private static List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n < k || n <= 0)
            return Collections.emptyList();
        
        List<List<Integer>> res = new ArrayList<>();
        int[] ans =  new int[k];
        
        int i = 0;
        while(i >= 0){
        		System.out.println(i);
        		System.out.println(Arrays.toString(ans) + "\n");
        		ans[i]++;        		
        		if (ans[i] > n)	// right most reaches limit, increase its left
        			i--;
        		else if(i == k - 1){ // if has an answer
        			List<Integer> temp = new ArrayList<>();
        			for (int num:ans)
        				temp.add(num);
        			res.add(temp);
        		}        			
        		else{	// reach a limit in previous step
        			i++;
        			ans[i] = ans[i - 1];        			
        		}        			
        }
        
        return res;
    }
	
    
/*    // recursive method: 50%
    private static List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n < k || n <= 0)
            return Collections.emptyList();
        
        List<List<Integer>> res = new ArrayList<>();        
        construct(res, new ArrayList<>(), 1, n, k);        
        return res;
    }
    
    private static void construct(List<List<Integer>> res, List<Integer> ans, int cur,  int n, int k){
		if (ans.size() == k){
			res.add(new ArrayList<>(ans));			
			return;
		}
    		
    		for (int i = cur; i <= n; i++){
    			ans.add(i);
    			cur++;
    			construct(res, ans, cur, n, k);
    			ans.remove(ans.size() - 1);
    		}    		
    }
*/    
    public static void main(String[] args){
    		int n = 6;
    		int k = 4;
    		List<List<Integer>> com = combine(n, k);
  	
    }
    
}






