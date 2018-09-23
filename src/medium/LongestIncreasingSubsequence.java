package medium;

class LongestIncreasingSubsequence {
    private int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;

        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++){
           dp[i] = 1;
        }
        int result = 1;

        for(int i = 1; i < len; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            if (dp[i] > result)
                result = dp[i];
        }

        return result;
    }
}
