package medium;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length < 1) {
            return -1;
        }

        int n = nums.length - 1;
        int targetSum = 0;
        int actualSum = 0;

        for(int i = 1; i <= n; i++) {
            targetSum += i;
        }

        for(int i = 0; i < nums.length; i++) {
            actualSum += nums[i];
        }

        return actualSum - targetSum;
    }
}
