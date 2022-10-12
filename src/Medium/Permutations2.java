package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations2 {
    static private List<List<Integer>> permuteUnique(int[] nums) {
        int length = nums.length;
        if (length < 1) return Collections.emptyList();
        
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        
        	combine(nums, used, new ArrayList<>(), result);      		
        
    		return result;        
    }
    
    static private void combine(int[] nums, boolean[] used, ArrayList<Integer> ans, List<List<Integer>> result){
		if (ans.size() == nums.length)	{
			result.add(new ArrayList<>(ans));
			return;
		}
		
		for (int i = 0; i < nums.length; i++){
			if (used[i])
				continue;
	    		if (i > 0 && nums[i] == nums[i-1] && !used[i - 1])
	    			continue;
	
	    		ans.add(nums[i]); 
	    		used[i] = true;
	    		combine(nums, used, ans, result);
	    		ans.remove(ans.size() - 1);
	    		used[i] = false;
		}
		    
		return;
    }
    
    public static void main(String[] args){
    		int[] nums = {1,2,2};
    		System.out.println(permuteUnique(nums));
    		
    		return;
    }
}
