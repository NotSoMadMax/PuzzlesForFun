package Easy;

public class SearchInsertPosition {
    private int searchInsert(int[] nums, int target) {
        int length = nums.length;
        if (length < 1)	return -1;
        int l = 0;
        int h = length - 1;
        while(h >= l){
        		int m = l + (h - l)/2;        		
        		if (nums[m] == target)	return m;
        		if (nums[m] > target)	h = m - 1;
        		else l = m + 1;
        }
        
    		return l;
    }
    
    public static void main(String[] args){
    	
    }
}
