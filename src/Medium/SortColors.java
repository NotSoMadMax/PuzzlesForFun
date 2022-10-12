package medium;

public class SortColors {
	private void sort(int[] nums){
        if (nums == null || nums.length <= 1)
            return;
        
        int r = 0, b = nums.length - 1, cur = 0;
        while (cur <= b){
            if(nums[cur] == 1){
                cur++;
                continue;
            } else if (nums[cur] == 0){
                int temp = nums[r];
                nums[r] = nums[cur];
                nums[cur] = temp;
                r++;
                cur++;
            } else if (nums[cur] == 2){
                int temp = nums[b];
                nums[b] = nums[cur];
                nums[cur] = temp;           
                b--;
            }            
        }
        		
	}
}
