package Easy;

class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 1 || 
        	k == 0 || (k % nums.length) == 0) {
        	return;
        }

        int nOfMove = nums.length;

        int curValue = nums[0];
        int curIndex = 0;
        
        int startIndex = 0;        
        for(int count = 0; count < nOfMove; count++) {        	
        	
        	int target = (curIndex + k) % nOfMove;
        	int temp = nums[target];
        	nums[target] = curValue;
        	
        	curValue = temp;
        	curIndex = target;

        	// One cycle
        	if(curIndex == startIndex) {
        		curIndex = ++startIndex;
        		curValue = nums[curIndex];
        	}
        }        
    }

	// Method 2
    public void rotate2(int[] nums, int k) {
        if (nums == null || nums.length < 1 || 
        	k == 0 || (k % nums.length) == 0) {
        	return;
        }

        k %= nums.length;
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, 0, nums.length - 1);
    }

    // Inclusive
    private void reverse(int[] nums, int start, int end) {
    	while(start < end) {
    		int temp = nums[start];
    		nums[start] = nums[end];
    		nums[end] = temp;
    		start++;
    		end--;
    	}
    }
}