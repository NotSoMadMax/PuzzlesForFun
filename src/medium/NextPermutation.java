package medium;

import java.util.Arrays;

public class NextPermutation {
	static private void nextPermutation(int[] nums){
		int length = nums.length;
		if (length < 2) return;
		
		int x = length - 2;
		
		while (x >= 0 && nums[x]>=nums[x+1])	x--;
		
		if (x == -1) {	// nums is the largest value
			Arrays.sort(nums);
			return;
		}
		
		//System.out.println("\n" + nums[x]);
		
		int y = x + 1;
		for (int i = length - 1; i > x; i--){
			if (nums[i] > nums[x]){
				y = i;
				break;
			}				
		}
		//System.out.println("\n" + nums[y]);
		
		int temp = nums[y];
		nums[y] = nums[x];
		nums[x] = temp;
		Arrays.sort(nums, x + 1, length); // sort [start, end)
		return;
	}
	
	public static void main(String args[]){
		int[] nums = {1,3,2};
		for (int n:nums)
			System.out.print(n);
		nextPermutation(nums);
		
		System.out.print("\n\n");
		for (int n:nums)
			System.out.print(n);
		
		return;
	}
}
