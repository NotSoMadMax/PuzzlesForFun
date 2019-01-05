package medium;

import java.util.HashMap;
import java.util.Map;

class SplitArrayintoConsecutiveSubsequences {
    private boolean isPossible(int[] nums) {
    	Map<Integer, Integer> count = new HashMap<>();
    	Map<Integer, Integer> needed = new HashMap<>();
    	
    	for(int n:nums)
    		count.put(n, count.getOrDefault(n, 0) + 1);
    	
    	for(int n:nums){
    		if(count.get(n) == 0)
    			continue;
    		else if(needed.get(n) != null && needed.get(n) != 0)	// can be appended to a sequence
    		{
    			count.put(n, count.get(n) - 1);
    			needed.put(n + 1, needed.getOrDefault(n + 1, 0) + 1);
    			needed.put(n, needed.get(n) - 1);
    		}
    		else if(count.get(n + 1) != null && count.get(n + 2) != null 
    				&& count.get(n+1) > 0 && count.get(n+2) > 0)		// can start a new sequence
    		{
    			count.put(n, count.get(n) - 1);
    			count.put(n+1, count.get(n+1) - 1);
    			count.put(n+2, count.get(n+2) - 1);
    			needed.put(n+3, needed.getOrDefault(n+3, 0) + 1);
    		}
    		else
    			return false;
    	}
    	
    	return true;
    }
}
