package medium;

import java.util.Arrays;

public class SearchRange {
	
	private static int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if (length == 0)		return result;
        if (length == 1) {
        		if (nums[0] == target){
        			result[0] = 0;
        			result[1] = 0;
        			return result;
        		} else
        			return result;
        }
	    if (target < nums[0] || target > nums[length - 1])
			return result;
		
		int l = 0;
		int h = length - 1;
		result[0] = l;
		result[1] = h;
		while (h > l && (h - l) != 1){
			int m = l + (h - l)/2;
			if (nums[m] < target)
				l = m;
			else
				h = m;
			result[0] = l;
			result[1] = h;
		}
                
		return result;
    }
	
	
	public static void main(String[] args) {
		int[] nums = {1,3,5};	//{5,5,7,9,13}
		int target = 3;
		int[] pos = searchRange(nums, target);
		System.out.println(Arrays.toString(pos));
		
		return;
	}

}
