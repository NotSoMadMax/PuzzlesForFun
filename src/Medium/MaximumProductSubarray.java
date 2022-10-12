package medium;

public class MaximumProductSubarray {
		
    private static int maxProduct(int[] nums) {
        if (nums==null || nums.length < 1)
        	return 0;
        
        int len = nums.length;
        int result = nums[0];
        int[] max = new int[len];
        int[] min = new int[len];      
        max[0] = nums[0];
        min[0] = nums[0];
        for (int i = 1; i < len; i++){        	
        	max[i] = Math.max(Math.max(max[i-1]*nums[i], nums[i]), min[i-1]*nums[i]);
        	min[i] = Math.min(Math.min(max[i-1]*nums[i], nums[i]), min[i-1]*nums[i]);
        	if (max[i]>result)
        		result = max[i];
        }
        
        return result;
    }
	

}
