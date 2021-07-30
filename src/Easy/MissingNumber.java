package Easy;

public class Solution {
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

    public int missingNumber2021(int[] nums) {
        int sum = 0;
        int expectedSum = 0;
        for(int i = 1; i <= nums.length; i++) {
            expectedSum += i;
            sum += nums[i - 1];
        }
        return expectedSum - sum;
    }
}