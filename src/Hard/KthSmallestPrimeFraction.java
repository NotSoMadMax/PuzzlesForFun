package Hard;

import java.util.Comparator;
import java.util.PriorityQueue;


class KthSmallestPrimeFraction {
	
	// Method 1: Heap
	class Fraction_Compare implements Comparator<int []>{
		public int compare(int[] a, int[] b){
			return nums[a[0]]*nums[b[1]] - nums[a[1]]*nums[b[0]];
		}
	}
	
	int[] nums;
    private int[] kthSmallestPrimeFraction(int[] A, int K) {
        if(A == null || A.length < 2)
        	return null;
        
        nums = A;
        int len = A.length;
        PriorityQueue<int[]> q = new PriorityQueue<>(new Fraction_Compare());	// take index
        for(int i = 1; i < len; i++)
        	q.add(new int[]{0, i});
        
        int cur = 0;        
        while(cur < K - 1){
        	int[] temp = q.poll();
        	if(temp[0] + 1 < temp[1])
        		q.add(new int[]{temp[0] + 1, temp[1]});
        	cur++;
        }
        
        int[] res = q.poll();
        return new int[]{A[res[0]], A[res[1]]};
    }
    
    
    // Method 2: Binary Search
    private int[] kthSmallestPrimeFraction2(int[] A, int K) {
        if(A == null || A.length < 2)
        	return null;
        
        int[] res = new int[2];
        double l = 0, r = 1.0; 
        
        while(r - l > 1e-9){
        	double mid = (l + r)/2.0;
        	int[] ans = search(A, mid);
        	
        	if(ans[0] < K)
                l = mid;          	    		      	
        	else
            {
                r = mid;  
        		res[0] = ans[1];
            	res[1] = ans[2];
            }        		        	
        }
        
        return res; 
    }
    
    // count the number of fractions that are smaller than target
    // return count, numerator, denominator
    private int[] search(int[] nums, double target){
    	int nume = 0;
    	int[] res = new int[3];
    	res[1] = 0;
    	res[2] = 1;
    	
    	for(int deno = 1; deno < nums.length; deno++){	// when deno increase, fraction will become smaller, so just increase nume from there and check
    		while((double)nums[nume]/nums[deno] < target)
    			nume++;
    		
    		res[0] += nume;
    		
            if(nume > 0 && (double)nums[nume - 1]/nums[deno] > (double)res[1]/res[2]){
    			res[1] = nums[nume - 1];
    			res[2] = nums[deno];
    		}
    	}
    	    	
    	return res;
    }
}






