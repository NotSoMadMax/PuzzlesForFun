package Easy;

public class MergeSortedArray {
	
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	if (nums1 == null && nums2 == null)
    		return;
    	
    	if(n == 0)
    		return;
    	
    	int cur1 = m - 1, cur2 = n - 1, cur_res = m + n - 1;
    	
    	while(cur1 >= 0 && cur2 >= 0) {
    		if(nums1[cur1] > nums2[cur2]) 
    			nums1[cur_res--] = nums1[cur1--];
    		else
    			nums1[cur_res--] = nums2[cur2--];
    	}
    	
    	while (cur1 >= 0) 
    		nums1[cur_res--] = nums1[cur1--];
    	
    	while(cur2 >= 0) 
    		nums1[cur_res--] = nums2[cur2--];
    	
    	
    	return;
    }
	
	public static void main (String args[]){
		System.out.println("wtf??dsdfsd?");
	}
	
}