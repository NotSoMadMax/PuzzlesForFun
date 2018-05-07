package Easy;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedArray {
    static private int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length < 2)	return length;
        int left = 0,right = 1;
        
        while (right < length){        		
        		if (nums[left] != nums[right]){
        			left++;
        			nums[left] = nums[right];
        		}
        		right++;	
        }        
        
        System.out.println(Arrays.toString(nums));
        return left + 1;
    }
	public static void main(String[] args) {
		int[] nums = {1,2,2};
		int newlen = removeDuplicates(nums);
		System.out.println(newlen);
		return;
	}

}
