package medium;

class PredicttheWinner {
	
	// Method 1: Brutal Force
    private boolean PredictTheWinner1(int[] nums) {
        if(nums == null || nums.length < 1)
        	return true;
        
        return play(nums, 0, nums.length - 1, 1, 0) >= 0;
    }
    
    private int play(int[] nums, int start, int end, int player, int score1){  // score1: score of player 1
    	// player 1: 1, player 2: -1
    	
    	if(start ==  end)
    		return score1 + player*nums[start];
    	
    	int option1 = play(nums, start + 1, end, player*(-1), score1 + player*nums[start]);
    	int option2 = play(nums, start, end - 1, player*(-1), score1 + player*nums[end]);
    	
    	if(player == 1)
    		return Math.max(option1, option2);
    	else
    		return Math.min(option1, option2);
    }
    
    
    // Method 2: DP
    private boolean PredictTheWinner2(int[] nums) {
        if(nums == null || nums.length < 1)
        	return true;
        
        int len = nums.length;
        int[][] dp = new int[len][len];
        
        for(int end = 0; end < len; end++){
        	for(int start = end - 1; start >= 0; start--){
        		int option1 = nums[start] - dp[start+1][end];
        		int option2 = nums[end] - dp[start][end - 1];
        		
        		dp[start][end] = Math.max(option1, option2);
        	}
        }
        
        return dp[0][len - 1]>=0;
    }
}



















