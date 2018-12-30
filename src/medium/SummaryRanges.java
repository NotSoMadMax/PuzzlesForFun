package medium;

import java.util.*;

class SummaryRanges {
    private List<String> summaryRanges(int[] nums) {
        if(nums == null || nums.length < 1)
        	return Collections.emptyList();
        
        int len = nums.length;
        List<String> res = new ArrayList<>();
        for(int i = 0; i < len;){
        	int cur = i + 1;

        	while(cur < len){
        		if(nums[cur] - 1 == nums[cur - 1])
        			cur++;        			        				
        		else
        			break;
        	}
        	
        	if(cur == i+1)
        		res.add(nums[i] + "");
        	else
        		res.add(nums[i] + "->" + nums[cur - 1]);
        	
        	i = cur;
        }
        
        return res;
    }
}











