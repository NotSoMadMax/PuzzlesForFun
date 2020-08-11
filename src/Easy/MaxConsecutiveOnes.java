package Easy;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i = 0;
        int maxCount = 0;
        while (i < nums.length) {
            int curCount = 0;
            while (i < nums.length && nums[i++] == 1) {
                curCount++;
            }
            if (curCount > maxCount) {
                maxCount = curCount;
            }
        }

        return maxCount;
    }
}
