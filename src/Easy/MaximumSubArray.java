package Easy;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MaximumSubArray {
	
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len < 1 || nums == null)    return 0;
        
        int max = nums[0];
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++){
        		dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        		if (dp[i] > max)
        			max = dp[i];
        }
        
        return max;
    }
	
	
	// top-down dp: stack overflow
	/*
    private int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len < 1 || nums == null)    return 0;
        
        int[] dp = new int[len];
        dp[len - 1] = DPhelper(nums, dp, len - 1);
        Arrays.sort(dp);
        return dp[len - 1];
    }
    
    static private int DPhelper(int[] nums, int[] dp, int end){
    		if (end == 0){
    			dp[end] = nums[end];
    			return nums[end];
    		}    			    		    			 
    		
    		dp[end] = Math.max(DPhelper(nums, dp, end - 1) + nums[end], nums[end]);
    		return dp[end];
    }
    */
}
