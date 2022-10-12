package medium;

import java.util.*;

class FindKClosestElements {
	
	// Binary search and expand from there
    private List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr == null || arr.length < 1)
        	return Collections.emptyList();
        
        int len = arr.length;
        int l = 0, r = len - 1;
        while(l < r){	// search lower bound
        	int m = l + (r - l + 1)/2;
        	if(arr[m] <= x)
        		l = m;
        	else	// x < arr[m]
        		r = m - 1;
        }
        
        int loc = l;
        l = Math.max(loc - k, 0);
        r = Math.min(loc + k, len - 1);
        
        while(r - l > k -1){
        	if(x - arr[l] <= arr[r] - x)
        		r--;
        	else if(x - arr[l] > arr[r] - x)
        		l++;
        }     	        		        	
        
        List<Integer> res = new ArrayList<>();
        for(int i = l; i <= r; i++)
        	res.add(arr[i]);
        
        return res;
    }
}
