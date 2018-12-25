package medium;

import java.util.*;

class PartitiontoKEqualSumSubsets {
	
	// Method 1: Brutal Force
    private boolean canPartitionKSubsets1(int[] nums, int k) {
        if(nums == null || nums.length < 1)
        	return false;
        
        int len = nums.length;
        if(k > len)
        	return false;
        
        int sum = Arrays.stream(nums).sum();
        if(sum % k != 0)
        	return false;        
        int target = sum/k;
        
        Arrays.sort(nums);        
        if(nums[len - 1] > target)
        	return false;
        
        boolean[] visited = new boolean[len];
        return search(nums, visited, len - 1, 0, k, target);
    }
    
    private boolean search(int[] nums, boolean[] visited, int cur_pos, int cur_sum, int k, int target){
    	if(k == 1)
    		return true;
    	
    	if(cur_sum == target)	// find one subset
    		return search(nums, visited, nums.length - 1, 0, k - 1, target);
    	
    	for(int i = cur_pos; i >= 0; i--){	// reverse order reduces run time
    		if(visited[i])
    			continue;
    		
    		visited[i] = true;
    		if(search(nums, visited, i - 1, cur_sum + nums[i], k, target))
    			return true;
    		visited[i] = false;
    	}
    	
    	return false;
    }
}
