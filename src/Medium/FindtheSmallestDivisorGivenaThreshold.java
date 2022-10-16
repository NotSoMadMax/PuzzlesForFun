class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int min = 1;
        int max = nums[0];
        for(int n : nums) {
            max = Math.max(max, n);
        }
        
        while(min < max) {
            int mid = min + (max - min) / 2;
            int sum = getSum(nums, mid);
            
            if(sum <= threshold) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        
        return max;
    }
    
    private int getSum(int[] nums, int div) {
        int sum = 0;
        for(int n : nums) {
            sum += (n + div - 1) / div;
        }
        return sum;
    }
}