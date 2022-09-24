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
}