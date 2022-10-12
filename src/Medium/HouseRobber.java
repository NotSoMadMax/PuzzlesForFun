class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length < 1) {
            return 0;
        }
        
        int[] amountRobAt = new int[nums.length];
        Arrays.fill(amountRobAt, -1);
        
        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            result = Math.max(result, findMax(i, nums, amountRobAt));
        }
        
        return result;
    }
    
    private int findMax(int start, int[] nums, int[] amountRobAt) {
        if (start >= nums.length) {
            return 0;
        }
        if (amountRobAt[start] != -1) {
            return amountRobAt[start];
        }
        
        int maxAmount = nums[start];
        for(int i = start + 2; i < nums.length; i++) {
            maxAmount = Math.max(maxAmount, nums[start] + findMax(i, nums, amountRobAt));
        }
        amountRobAt[start] = maxAmount;
        
        return maxAmount;
    }

    // Method 2: DP
    public int rob2(int[] nums) {
        if(nums == null || nums.length < 1) {
            return 0;
        }
        if (nums.length < 2) {
            return nums[0];
        }
        
        int[] maxRobTo = new int[nums.length];
        maxRobTo[0] = nums[0];
        maxRobTo[1] = Math.max(maxRobTo[0], nums[1]);
        for(int i = 2; i < nums.length; i++) {
            maxRobTo[i] = Math.max(maxRobTo[i - 1], nums[i] + maxRobTo[i - 2]);
        }
   
        return maxRobTo[nums.length - 1];
    }
}