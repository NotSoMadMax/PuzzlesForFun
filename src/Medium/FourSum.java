package medium;

import java.util.*;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class FourSum {

	public List<List<Integer>> fourSum(int[] nums, int target) {
		if(nums == null || nums.length < 1)
			return Collections.emptyList();

		Arrays.sort(nums);
		int len = nums.length;
		List<List<Integer>> res = new ArrayList<>();

		for(int i = 0; i <= len - 4; i++) {
			if (i != 0 && nums[i] == nums[i - 1])
				continue;

			for (int j = i + 1; j <= len - 3; j++) {
				if (j != i + 1 && nums[j] == nums[j - 1])
					continue;

				int left = j + 1, right = len - 1;
				int cur_target = target - nums[i] - nums[j];
				while (left < right) {
					if (nums[left] + nums[right] < cur_target)
						left++;
					else if (nums[left] + nums[right] > cur_target)
						right--;
					else {
						List<Integer> ans = new ArrayList<>();
						ans.add(nums[i]);
						ans.add(nums[j]);
						ans.add(nums[left]);
						ans.add(nums[right]);
						res.add(ans);

						while (left < right && nums[left] == nums[left + 1])
							left++;
						while (left < right && nums[right] == nums[right - 1])
							right--;
						left++;
						right--;
					}
				}
			}
		}

		return res;
	}

	// naive and broken
	/*
    private static List<List<Integer>> threeSum(int[] nums, int target) {
   	 	Arrays.sort(nums);       
        int len = nums.length;
        
        if (len < 3 || (target < 0 && nums[0] >=0) || (target > 0 && nums[len - 1] <= 0))
        	return Collections.emptyList();
        if (3 * nums[len - 1] < target || 3 * nums[0] > target)
        	return Collections.emptyList();
        
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < len - 2; i++){
	       	 int l = i + 1, r = len - 1;
	       	 while(l < r){
	       		 int sum = nums[i] + nums[l] + nums[r];
	       		 if (sum == target && !result.contains(Arrays.asList(nums[i], nums[l], nums[r])))
	       			 result.add(Arrays.asList(nums[i], nums[l], nums[r]));
	       		 else if (sum < target)
	       			 l++;
	       		 else
	       			 r--;
	       	 }
        }        
        return result;
   }
	
    private static List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        
        if (len < 4 || (target < 0 && nums[0] >=0) || (target > 0 && nums[len - 1] <= 0))
			return Collections.emptyList();
        if (4 * nums[len - 1] < target || 4 * nums[0] > target)
        	return Collections.emptyList();
        
		List<List<Integer>> result = new ArrayList<>();
		
		for (int i = 0; i < len; i++){
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int[] newNums = new int[len - 1];
			boolean flag = true;
			for (int x = 0; x < len; x++){	// construct a new nums for 3sum
				if (x == i){
					flag = false;
					continue;
				}
				if (flag)				
					newNums[x] = nums[x];
				else
					newNums[x - 1] = nums[x];
			}
			
			List<List<Integer>> sum3 = threeSum(newNums, target - nums[i]);
			if (sum3.isEmpty())
				continue;
			
			int threelen = sum3.size();
			for (int j = 0; j < threelen; j++){
				List<Integer> temp = sum3.remove(0);
				result.add(0, Arrays.asList(temp.get(0), temp.get(1), temp.get(2), nums[i]));
			}
		}
			
    	return result;
    }
    
    
    public static void main(String[] args){
    	int[] nums = {1,2,3,4,5,6,7,8};
    	System.out.println(fourSum(nums, 17));
    	return;
    }
    */
}














