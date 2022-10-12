package medium;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Subsets {
    private static List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length < 1)
            return Collections.emptyList();
        
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        res.add(ans);
        search(nums, 0, ans, res);
        
        return res;
    }
    
    private static void search(int[] nums, int cur, List<Integer> ans, List<List<Integer>> res){
        
        for (int i = cur; i < nums.length; i++){
        		ans.add(nums[i]);
        		res.add(new ArrayList<>(ans));
        		search(nums, i + 1, ans, res);
        		ans.remove(ans.size() - 1);
        }
        
        return;
    } 
    
    public static void main(String[] args){
    		int[] nums = {1,2,3};
    		List<List<Integer>> res = subsets(nums);
    		for (List<Integer> l:res)
    			System.out.println(l.toString());
    }
}



