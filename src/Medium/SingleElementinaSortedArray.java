class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length < 2) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        
        while(left < right) {
            int mid = left + (right - left) / 2;
            
            // round it to the cloest even number
            if(mid % 2 != 0) {
                mid--;
            }
            
            // if the single numer hasn't be seen, even location should be the first of the two repeating number
            if(nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}