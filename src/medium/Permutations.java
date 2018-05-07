package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {
    static private List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        if (length < 1) return Collections.emptyList();
        
        List<List<Integer>> result = new ArrayList<>();
        
        	combine(nums, new ArrayList<>(), result);      		
        
    		return result;
    }
    
    static private void combine(int[] nums, ArrayList<Integer> ans, List<List<Integer>> result){
    		if (ans.size() == nums.length)	{
    			result.add(new ArrayList<>(ans));
    			return;
    		}
    		
    		for (int i = 0; i < nums.length; i++){
        		if (ans.contains(nums[i]))
        			continue;

        		ans.add(nums[i]);  
        		combine(nums, ans, result);
        		ans.remove(ans.size() - 1);
    		}
    		    
    		return;
    }
    
    public static void main(String[] args){
    		int[] nums = {1,2,3};
    		System.out.println(permute(nums));
    }
}
