package Easy;

class Solution {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length < 1) {
        	return -1;
        }

        int expectedSum = 0;
        for(int i = 0; i <= nums.length; i++) {
        	expectedSum += i;
        }
        
        for(int i : nums) {
        	expectedSum -= i;
        }

        return expectedSum;
    }
}