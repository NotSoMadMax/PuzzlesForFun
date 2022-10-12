package medium;import java.util.function.BinaryOperator;

public class SearchinRotatedSortedArray {
    static private int search(int[] nums, int target) {
        int length = nums.length;
        if(length == 0)	return -1;
        if(length == 1)	return nums[0] == target ? 0:-1;
        
        int piv = 1;
        while(piv < length && nums[piv] > nums[piv - 1])	piv++;
        
        if (piv == length)	return binary(nums, 0, length - 1, target);
        
        if (target > nums[piv - 1] || target < nums[piv])		return -1;        
        if (nums[0] <= target && target <= nums[piv - 1])
        		return binary(nums, 0, piv - 1, target);
        else if (target <= nums[length - 1] && nums[piv] <= target)
        		return binary(nums, piv, length - 1, target);
        	else
        		return -1;
    }
    
    private static int binary(int[] nums, int l, int h, int target){
    		if (nums[l] > target || nums[h] < target)	return -1;
    		if (h - 1 == l && nums[l] != target && nums[h] != target)		return -1;
    		if (nums[h] == target)	return h;
    		
    		int m = l + (h - l)/2;
    		if (nums[m] == target)	return m;
    		else if (nums[m] > target)	return binary(nums, l, m, target);
    		else return binary(nums, m, h, target);
   		
    }
    
   /*// time limit exceed
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length < 1)
        	return -1;
        
        int len = nums.length;
        if (len == 1) {
        	if (nums[0] == target)
        		return 0;
        	else
        		return -1;
        }
        
        int offset = 1;
        while(offset < len && nums[offset] >= nums[offset - 1])
        	offset++;
        
        int l = offset, r = offset - 1;
               
        while ((l - offset + len)%len <= (r - offset + len)%len)
        {
            int m = ((l - offset + len)%len + ((r - offset + len)%len-(l - offset + len)%len)/2 + offset)%len;
 
            if (nums[m] == target)
                return m;
 
            if (nums[m] < target)
                l = (m + 1)%len;
 
            else
                r = (m - 1 + len)%len;
        }
        
        return -1;
    }
    */
    public static void main(String args[]){
    		int[] nums = {1,3};
    		System.out.println(search(nums, 0));
    }
}
