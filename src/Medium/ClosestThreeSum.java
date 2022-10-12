package medium;

import java.util.Arrays;
import java.util.Collections;

public class ClosestThreeSum {
    private static int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len - 2; i++){
        	int l = i + 1, r = len - 1;
        	while (l < r){
        		int sum = nums[i] + nums[l] + nums[r];
        		int diff = sum - target;
        		if (Math.abs(diff) < Math.abs(closest - target))
        			closest = sum;
        		if (diff == 0)
        			return target;
        		else if (diff > 0)
        			r--;
        		else
        			l++;
        	}
        }
        
    	return closest;
    }
    
    public static void main(String args[]){
    	int[] nums = {0,1,2};
    	int target = 0;
    	System.out.println(threeSumClosest(nums, target));
    	return;
    }
    
}
