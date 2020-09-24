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

	// 2020
    // Greedy
    public boolean canJump2020(int[] nums) {
        if (nums == null || nums.length < 1) {
            return true;
        }

        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) {
                return false;
            }
            if (farthest >= nums.length - 1) {
                return true;
            }
            farthest = Integer.max(farthest, i + nums[i]);
        }

        return farthest >= nums.length - 1;
    }

    // 2020
    // DP
    public boolean canJump20202(int[] nums) {
        int[] dp =  new int[nums.length];   // the number of moves left when reached location i
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i - 1]) - 1;
            if (dp[i] < 0) {
                return false;
            }
        }

        return dp[nums.length - 1] >= 0;
    }
}
                 