package Easy;

class RangeSumQuery {

    private int[] dp;
    public NumArray(int[] nums) {
        if(nums == null || nums.length < 1)
            return;

        dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = dp[i - 1] + nums[i];
        }
    }

    private int sumRange(int i, int j) {
        if (dp == null)
            return 0;

        return i == 0?dp[j]:dp[j] - dp[i - 1];
    }
}
