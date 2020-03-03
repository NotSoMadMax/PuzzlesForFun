package medium;

import java.util.Arrays;

class TargetSum {
	// Method 1: Brutal force recursion
    public int findTargetSumWays1(int[] nums, int S) {
        if (nums == null || nums.length < 1)
        	return 0;
        
        return search(0, nums, 0, S);
    }
    
    private int search(int i, int[] nums, int sum, int S) {
    	if(nums.length == i) {
    		return sum == S ? 1 : 0;  	    		
    	}
    	
    	return search(i + 1, nums, sum + nums[i], S) + search(i + 1, nums, sum - nums[i], S);
    }
    
    // Method 2: Search with memorization
    public int findTargetSumWays2(int[] nums, int S) {
        if (nums == null || nums.length < 1)
        	return 0;
        
        int[][] memo = new int[nums.length][2001];
        for(int[] r:memo)
        	Arrays.fill(r, Integer.MAX_VALUE);

        return search2(0, nums, 0, S, memo);
    }
    
    private int search2(int i, int[] nums, int sum, int S, int[][] memo) {
    	if(nums.length == i) {
    		return sum == S ? 1 : 0;  	    		
    	}    	    	
    	
    	if(memo[i][sum + 1000] != Integer.MAX_VALUE)
    		return memo[i][sum + 1000];
    			
    	int add = search2(i + 1, nums, sum + nums[i], S, memo);
    	int subt = search2(i + 1, nums, sum - nums[i], S, memo);
    	
    	memo[i][sum + 1000] = add + subt;
    	return memo[i][sum + 1000];
    }
    
    // Method 3: DP
    public int findTargetSumWays3(int[] nums, int S) {
    	if (nums == null || nums.length < 1|| S > 1000)
    		return 0;
    	
    	int len = nums.length;
    	int[][] dp = new int[len][2001];
    	
    	dp[0][nums[0] + 1000] = 1;
    	dp[0][-nums[0] + 1000] += 1;
    	
    	for(int i = 1; i < len; i++) {
    		for(int sum = -1000; sum < 1001; sum++) {
    			if(dp[i - 1][sum + 1000] > 0) {
    				dp[i][sum + nums[i] + 1000] += dp[i - 1][sum + 1000];
    				dp[i][sum - nums[i] + 1000] += dp[i - 1][sum + 1000];
    			}
    		}
    	}
    	
    	return dp[len - 1][S + 1000];
    }
}
