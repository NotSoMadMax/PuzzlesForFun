package medium;

public class HouseRobberII {
    private int rob(int[] nums) {
        if(nums == null || nums.length == 0)
        	return 0;
        
        int len = nums.length;
        if (len == 1)
        	return nums[0];
        if (len == 2)
        	return nums[0]>nums[1]?nums[0]:nums[1];
        	
        int r1 = rob1(0, len-2, nums);
        int r2 = rob1(1, len-1, nums);
        
        return r1>r2?r1:r2;
    }
    
    private int rob1(int start, int end, int[] nums){
    	int len = end - start + 1;
    	if(len == 0)
    		return nums[start];
    	
        int[] dp = new int[len];
        dp[0] = nums[start];
        dp[1] = nums[start];
        if (nums[start+1] > nums[start])
        	dp[1] = nums[start+1];
        
        for (int i = 2; i < len; i++){
        	dp[i] = Math.max(dp[i-2]+nums[start+i], dp[i-1]);
        }
    	            	
    	return dp[len - 1];
    }
}
