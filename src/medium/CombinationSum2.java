package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum2 {

	private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int length = candidates.length;
        if (length == 0 || candidates == null)	return Collections.emptyList();
		
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        
        	combination(candidates, target, 0, result, new ArrayList<Integer>());        
        
		return result;
    }
	
	private static void combination(int[] candidates, int target, int cur, List<List<Integer>> results, ArrayList<Integer> ans){
		if (target == 0) {
			results.add(new ArrayList<>(ans));
			return;
		}
		
		if (target < 0)	return;
		
		// if target > 0
		for (int i = cur; i < candidates.length; i++){
			if (i > cur && candidates[i - 1] == candidates[i])
				continue;
			ans.add(candidates[i]);
			int newTarget = target - candidates[i];
			combination(candidates, newTarget, i + 1, results, ans);
			ans.remove(ans.size() - 1);
		}		
		return;
	}
	
	public static void main(String[] args) {		
		int[] candi = {15,2,3,6,5,9,11,7,3,8,10,21,13,2,8};
		int target = 15;
		
		List<List<Integer>> result = combinationSum2(candi,target);
		System.out.println(result);
	}

}
