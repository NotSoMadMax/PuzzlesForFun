package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Subsets_II {
    private static List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums == null || nums.length < 1)
        		return Collections.emptyList();
        
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        search(nums, 0, new ArrayList<>(), res);
        return res;
    }
    
    private static void search(int[] nums, int cur, List<Integer> ans, List<List<Integer>> res){
    		
    		for (int i = cur; i < nums.length; i++){
    			if (i > cur && nums[i] == nums[i - 1])
    				continue;
    			ans.add(nums[i]);
    			System.out.println(ans);
    			res.add(new ArrayList<>(ans));
    			search(nums, i + 1, ans, res);
    			ans.remove(ans.size() - 1);
    		}
    }
    
    public static void main(String[] args){
    		int[] nums = {1,2,2,3,4};
    		List<List<Integer>> res = subsetsWithDup(nums);
//    		for (List<Integer> l:res)
//    			System.out.println(l.toString());
    }
}





