package medium;

public class FindFirstandLastPositionofElementinSortedArray {
	private int[] searchRange(int[] nums, int target) {
		int[] res = {-1, -1};
		
		if(nums == null || nums.length < 1)
			return res;
			
		int left = 0, right = nums.length - 1;
		
		// find left boundary
		while (left < right) {			
			int mid = left + (right - left)/2;
			if(nums[mid] < target)
				left = mid + 1;
			else
				right = mid;
		}
		
		if(nums[right] != target)
			return res;
		res[0] = right;
		
		right = nums.length;
		// find right boundary
		while(left < right){
			int mid = left + (right - left)/2;
			if(nums[mid] <= target)
				left = mid + 1;
			else
				right = mid;
		}
		res[1] = left - 1;
		
		return res;
	}
}
