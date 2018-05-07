package medium;

import java.util.Arrays;
import java.util.Stack;

public class RemoveDuplicatesfromSortedArrayII {
	
	private static int removeDuplicates(int[] nums){
		if (nums == null)
			return 0;
		int n = nums.length;
		if (n < 1)
			return 0;
		
		if (n < 3)
			return nums.length;
		
		int i = 2, j = 2;
		while(i < n && j < n){
			if (nums[j] == nums[i - 2]){
				j++;
			} else {
				nums[i] = nums[j];
				i++;
				j++;
			}
		}
		
		return i;
	}
	
	// % 29
//    private static int removeDuplicates(int[] nums) {
//        if (nums == null || nums.length < 1)
//            return 0;
//        if (nums.length == 1)
//            return 1;
//        
//        int count = 1;
//        int cur_count = 1;
//        int cur = 1;
//        
//        int[] result = new int[nums.length];
//        result[0] = nums[0];  
//        
//        for (int i = 1; i < nums.length; i++){
//            if (nums[i] == nums[i - 1]){
//                if (cur_count == 2)
//                    continue;
//                else{
//                		cur_count++;
//                		count++;
//                		result[cur] = nums[i];
//                		cur++;
//                }                             
//            } else {
//                cur_count = 1;
//                result[cur] = nums[i];
//                cur++;
//                count++;            	
//            }       		
//        }
//        
//        for (int i = 0; i < count; i++)
//        		nums[i] = result[i];        
//        
//        return count;
//    }
    
    public static void main(String[] args){
    		int[] nums = {1, 1};
    		int count = removeDuplicates(nums);
    		System.out.println(count);
    		System.out.println(Arrays.toString(nums));
    }
}





