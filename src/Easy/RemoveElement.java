package Easy;

import java.util.Arrays;

public class RemoveElement {
	
	static private int removeElement(int[] nums, int val) {
        int length = nums.length;
        int result;
        if (length < 1)	return length;
        
        Arrays.sort(nums);
        int pos = search(nums, val);        
        if (pos == -1)	return length;
        
        int l = pos, r = pos;
        while(l > 0 && nums[l - 1] == val)
        		l--;
        while(r < length - 1 && nums[r + 1] == val)
        		r++;
                
        if(r - l == length - 1)	return 0;
        if(r == length - 1) return length - (r - l) - 1;
                
        result = length - (r - l) - 1;
        for(int i = r + 1; i < length; i++){
        		nums[l] = nums[i];
        		l++;
        }
        System.out.println(Arrays.toString(nums));
        return result;
    }
	
	static private int search(int[] nums, int val){
		int l = 0, h = nums.length - 1;
		while(h >= l){
			int m = l + (h - l)/2;
			if (nums[m] == val)	return m;
			if (nums[m] > val)	h = m - 1;
			else		l = m + 1;
		}		
		return -1;
	}
	
	public static void main(String[] args){
		int[] test = {1,2,3,4};
		System.out.println(removeElement(test, 1));
	}
}
