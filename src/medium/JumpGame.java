package medium;

public class JumpGame {
	
	private static boolean canJump(int[] nums){
        int len = nums.length;
        if (len < 1 || nums == null)
        		return false;
        if (len == 1)
        		return true;
        
        int next = len - 1;
        for (int cur = len - 2; cur >= 0; cur--){
        		if (cur + nums[cur] >= next)
        			next = cur;        		
        }
        return next == 0;
	}
	
	/*	time limit exceed
    private static boolean canJump(int[] nums) {
        int len = nums.length;
        if (len < 1 || nums == null)
        		return false;
        if (len == 1)
        		return true;
        
        boolean[] memo = new boolean[len];
        memo[len - 1] = true;
        
		for (int cur = nums.length - 2; cur >= 0; cur--){
			int step = nums[cur];
			for (int i = 1; i <= step && (cur + i) < len; i++){
				if (memo[cur + i]){
					memo[cur] = true;
					break;
				}    				    			
    			}    			
		}
		return memo[0];				
    }	
    */
}
