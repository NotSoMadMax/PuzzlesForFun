package medium;

import java.util.*;


public class ThreeSum {
	private List<List<Integer>> threeSum(int[] nums) {
		if(nums == null || nums.length < 3)
			return Collections.emptyList();

		int len = nums.length;
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		for(int i = 0; i <= len - 3; i++){
			if(i != 0 && nums[i] == nums[i - 1])
				continue;
			if(nums[i] > 0)	// everything after this number will be positive
				break;

			int left = i + 1, right = len - 1, target = -nums[i];
			while (left < right){
				if(nums[left] + nums[right] < target)
					left++;
				else if(nums[left] + nums[right] > target)
					right--;
				else {
					List<Integer> ans = new ArrayList<>();
					ans.add(nums[i]);
					ans.add(nums[left]);
					ans.add(nums[right]);
					res.add(ans);

					while (left < right && nums[left] == nums[left+1])
						left++;
					while (left < right && nums[right] == nums[right - 1])
						right--;
					left++;
					right--;
				}
			}
		}

		return res;
	}


	/* young and green......
    private static List<List<Integer>> Naive_threeSum(int[] nums) {
        Arrays.sort(nums);       
        int len = nums.length;
        
        if (len < 3 || nums[0] > 0 || nums[len - 1] < 0)
        	return Collections.emptyList();
        
        int countZero = 0;
    		for (int i = 0; i < len; i++)	//find number of zeros
    			if (nums[i] == 0)
    				countZero++;
    	
    	int lastN = -1; // position of last negative number
    	int firstP = len; // position of the first positive number
    	for (int i = 0; i < len; i++){	// find position
    		
    		if (countZero == 0) {
    			if (nums[i] < 0){
    				lastN = i;
    				firstP = i + 1;
    			}
    		} else {
    			if (nums[i] < 0)
    				lastN = i;
    			if (nums[i] == 0)
    				firstP = i + 1;
    		}    		    			
    	}
    	
    	List<List<Integer>> result = new ArrayList<>();    	
    	
    	if (countZero >= 3)
    		result.add(Arrays.asList(0, 0, 0));
    	
    	int[][] sumtwoP = new int[len][len];	// two sum tale: p + p
    	for (int i = firstP; i < len - 1; i++){
    		for (int j = i + 1; j < len; j++){    			
    			sumtwoP[i][j] = nums[i] + nums[j];
    			//System.out.println(nums[i] + " + " + nums[j] + " = " + sumtwoP[i][j]);
    		}
    			
    	}
    	
    	int[][]	sumtwoN = new int[len][len];	// two sum tale: n + n
    	for (int i = 0; i < lastN; i++){
    		for (int j = i + 1; j < lastN + 1; j++){
    			sumtwoN[i][j] = nums[i] + nums[j];
    			//System.out.println(nums[i] + " + " + nums[j] + " = " + sumtwoN[i][j]);
    		}    			
    	}
    	
    	for (int i = 0; i <= lastN; i++){	// -++
    		int twosum = -nums[i];
    		for (int x = firstP; x < len - 1; x++){
    			for (int y = x + 1; y < len; y++){
    				if (sumtwoP[x][y] == twosum && !result.contains(Arrays.asList(nums[i], nums[x], nums[y])))
    					result.add(Arrays.asList(nums[i], nums[x], nums[y]));
    			}
    		}
    	}
    	
    	for (int i = firstP; i < len; i++){	// +--
    		int twosum = -nums[i];
    		for (int x = 0; x < lastN; x++){
    			for (int y = x + 1; y < lastN + 1; y++){       				
    				if (sumtwoN[x][y] == twosum && !result.contains(Arrays.asList(nums[i], nums[x], nums[y])))
    					result.add(Arrays.asList(nums[i], nums[x], nums[y]));
    			}
    		}
    	}
    	
    	if (countZero > 0){
        	for (int i = 0; i <= lastN; i++){
        		for (int j = firstP; j < len; j++){
        			if (nums[i] == -nums[j] && !result.contains(Arrays.asList(nums[i], 0, nums[j])))
        				result.add(Arrays.asList(nums[i], 0, nums[j]));
        		}
        	}
    	}
    	
    	return result;
    }
    
    
    private static List<List<Integer>> threeSum(int[] nums) {
    	 Arrays.sort(nums);       
         int len = nums.length;
         
         if (len < 3 || nums[0] > 0 || nums[len - 1] < 0)
         	return Collections.emptyList();
         
         List<List<Integer>> result = new ArrayList<>();
         for (int i = 0; i < len - 2; i++){
        	 int l = i + 1, r = len - 1;
        	 while(l < r){
        		 int sum = nums[i] + nums[l] + nums[r];
        		 if (sum == 0 && !result.contains(Arrays.asList(nums[i], nums[l], nums[r])))
        			 result.add(Arrays.asList(nums[i], nums[l], nums[r]));
        		 else if (sum < 0)
        			 l++;
        		 else
        			 r--;
        	 }
         }
         
    	return result;
    }
    
    
    public static void main(String argsp[]){
    	int[] nums = {1,2,-2,-1,1};
    	List<List<Integer>> sum3 = threeSum(nums);    	
    	
    	System.out.println(sum3);
    	return;
    }
    */
}





