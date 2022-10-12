package medium;

import java.util.*;

class MissingRanges {
    private List<String> findMissingRanges(int[] nums, int lower, int upper) {    
        int len = nums.length;
        List<String> res = new ArrayList<>();
        long expect = lower, cur = lower;
        for(int i = 0; i <= len; i++)
        {        	
        	if(i < len && nums[i] <= upper)
        		cur = nums[i];
        	else
        		cur = (long)upper + 1;
        	
        	if(expect == cur)
        		expect++;        	
        	else if(expect < cur){
        		if(expect + 1 == cur)
        			res.add(String.valueOf(expect));
        		else
        			res.add(expect + "->" + (cur - 1));
        		
        		expect = cur + 1;
        	}
        }

        return res;
    }
}







