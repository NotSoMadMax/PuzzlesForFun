package Easy;

public class HouseRobber {
    private int rob(int[] nums) {
        if (nums == null || nums.length < 1)
        	return 0;
        
        int len = nums.length;
        if (len == 1)
        	return nums[0];
                
        int[] sum = new int[len];
        sum[0] = nums[0];
        sum[1] = nums[1]>nums[0]?nums[1]:nums[0];
        for (int i = 2; i < len; i++){
        	sum[i] = Math.max(sum[i-2]+nums[i], sum[i-1]);
        }
        
        return sum[len-1];
    }
}
