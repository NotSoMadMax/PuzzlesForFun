package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum {

	static private List<List<Integer>> combinationSum(int[] candidates, int target) {
		int length = candidates.length;
		if (length == 0 || candidates == null)		return Collections.emptyList();
		
		Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();  
		combination(candidates, 0, target, new ArrayList<Integer>(), result);
		return result;
    }
	
	static private void combination(int[] candidates, int start, int target, ArrayList<Integer> ans,   
			List<List<Integer>> result){
		if (target == 0){
			result.add(new ArrayList<>(ans));
			return;
		} 
		if (target < 0)
			return;
		
		for (int i = start; i < candidates.length; i++){
			if (i > 0 && candidates[i] ==  candidates[i - 1])
				continue;
			
			ans.add(candidates[i]);
			int newtarget = target - candidates[i];
			combination(candidates, i, newtarget, ans, result);
			ans.remove(ans.size() - 1);
		}
		
		return;
	}
	
	public static void main(String[] args) {		
		int[] cand = {1,2,3,4,5};
		int target = 10;
		List<List<Integer>> res = combinationSum(cand, target);
		
		System.out.println(res);

	}
}
