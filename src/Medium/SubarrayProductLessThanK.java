package medium;

public class SubarrayProductLessThanK {
	
	// 8.47%
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(nums == null || nums.length < 1)
            return 0;

        if (k <= 1)
            return 0;

        int n = nums.length;
        long p = 1l;
        int i = 0, total = 0;

        for (int j = 0; j < n; j++){
            p *= nums[j];
            while (p >= k){
                p /= nums[i];
                i++;
            }
            total += (j - i + 1);
        }

        return total;
      }	
}
