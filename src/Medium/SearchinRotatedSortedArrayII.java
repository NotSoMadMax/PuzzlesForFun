package medium;

public class SearchinRotatedSortedArrayII {
	
	
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length < 1)
        	return false;
        
        int l = 0, r = nums.length - 1;
        
        while(l <= r) {
        	int m = l + (r - l)/2;
        	if(nums[m] == target)
        		return true;
        	
        	if(nums[m] < nums[r]) { // the second half is sorted
        		if(target > nums[m] && target <= nums[r])
        			l = m + 1;
        		else
        			r = m - 1;
        	} else if(nums[m] > nums[r]) { // the first half is sorted
        		if(target >= nums[l] && target < nums[m])
        			r = m - 1;
        		else
        			l = m + 1;
        	} else {
        		r--;
        	}
        }
        
        return false;
    }	
	

    
	public static void main(String[] args) {
		

	}

}
