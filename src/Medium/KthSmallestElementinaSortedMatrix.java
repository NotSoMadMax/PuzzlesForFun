package medium;

public class KthSmallestElementinaSortedMatrix {
    private int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length < 1 || matrix[0] == null || matrix[0].length < 1)
        	return -1;
        
        int len = matrix.length;
        int l = matrix[0][0], h = matrix[len-1][len-1];
        
        while(l < h){
        	int guess = (l + h)/2;
        	
        	// testify the guess
        	int count = 0;
        	for(int i = 0; i < len; i++)
        		count += countRow(matrix[i], guess);
        	if(count < k)
        		l = guess + 1;
        	else
        		h = guess;
        }
    	
    	return l;
    }
    
    private int countRow(int[] nums, int target){
    	int l = 0, h = nums.length;
    	while(l < h){
    		int m = (l + h)/2;
    		if(nums[m] <= target)
    			l = m + 1;
    		else
    			h = m;
    	}
    	
    	return l;
    }
}
