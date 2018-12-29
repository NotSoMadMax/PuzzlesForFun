package Hard;

import java.util.Arrays;

class SplitArrayLargestSum {
	
	// Method 1: DP
    private int splitArray1(int[] nums, int m) {
        
    	int len = nums.length;
    	int[][] dp = new  int[len+1][m+1];	// min max_sum when split [0, i] into j sets
    	int[] pre_sum = new int[len + 1];
    	
    	for(int[] row:dp)
    		Arrays.fill(row, Integer.MAX_VALUE);
    	
    	pre_sum[1] = nums[0];
    	for(int i = 2; i <= len; i++)
    		pre_sum[i] += pre_sum[i-1] + nums[i - 1];
    	
    	dp[0][0] = 0;
    	for(int i = 1; i <= len; i++)
    	{
    		for(int j = 1; j <= m; j++)
    		{
    			for(int k = 0; k < i; k++)
    			{
    				int cur_max_sum = Math.max(dp[k][j - 1], pre_sum[i] - pre_sum[k]);
    				dp[i][j] = Math.min(dp[i][j], cur_max_sum);
    			}
    		}
    	}
    	    	
    	return dp[len][m];
    }
    
    
    // Method 2: Binary Search
    private int splitArray2(int[] nums, int m) {
    	long right = 0;	// sum (when m = 1)
    	long left = 0;	// max element (when m = nums.length)
    	for(int n:nums){
    		right += n;
    		left = Math.max(left, n);
    	}
    	
    	long ans = right;
    	while(left <= right){
    		long mid = (left + right)/2;
    		
    		if(split(nums, mid, m)){
    			ans = Math.min(ans, mid);
    			right = mid - 1;
    		}
    		else
    			left = mid + 1;
    	}
    	
    	return (int) ans;
    }
    
    // try to split into m sets so that each sum is equal or smaller than target_sum
    private boolean split(int[] nums, long target_sum, int m){
    	int number_sets = 1;
    	long cur_sum = 0;
    	for(int i = 0; i < nums.length; i++){
    		cur_sum += nums[i];
    		
    		if(cur_sum > target_sum){
    			number_sets++;
    			cur_sum = nums[i];    			
    		}
    		
    		if(number_sets > m)
    			return false;
    	}
    	
    	return true;
    }
}












