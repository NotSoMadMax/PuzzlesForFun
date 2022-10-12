package medium;

import java.util.Arrays;

public class InvertedArray {
	static private int inverted_index(int[] arr, int target){		
        int l = 0, h = arr.length - 1;
        while (l <= h) {
            int m = l + (h-l)/2;
            if (arr[m] == target)
                return m;
            if (arr[m] < target)
                l = m + 1;
            else
                h = m - 1;
        }
        return -1;		
	}
	
	static private void convert(int[] arr){
		int n = arr.length;
	    int[] temp = new int[n];
	    for (int i=0; i<n; i++)
	        temp[i] = arr[i];
	    Arrays.sort(temp);
	     
	    for (int i=0; i<n; i++) {	// index of arr[i] in sorted array	    		
	        arr[i] = inverted_index(temp, arr[i]);	        
	    }
	    return;
	}
	
    static private int getSum(int BITree[], int index) {
        int sum = 0; // Initialize result
        // Traverse ancestors of BITree[index]
        index = index + 1;
        while (index > 0) {        	    
            // Add current element of BITree to sum
            sum += BITree[index];
            // Move index to parent node in getSum View
            index -= index & (-index);
        }
        return sum;
    }	
    
    static private void updateBIT(int BITree[], int n, int index, int val) {        
        // Traverse all ancestors and add 'val'
    		index = index + 1;
        while (index <= n) {
            // Add 'val' to current node of BI Tree
            BITree[index] += val;
            // Update index to that of parent in update View
            index += index & (-index);            
        }
    }
    
    private static long countInv(int[] arr){
    		int n = arr.length;
        convert(arr);
        
        // Create and initialize smaller and greater arrays
        int greater1[]= new int[n];
        int smaller1[]= new int[n];
 
        // Create and initialize an array to store Binary Indexed Tree
        int BIT[]= new int[n+1];

        for (int i = n - 1; i >= 0; i--) {        		
            smaller1[i] = getSum(BIT, arr[i] - 1);
            System.out.println("current:" + arr[i]+" count smaller:" + smaller1[i]);
            updateBIT(BIT, n, arr[i], 1);
        }
 
        // Reset BIT
        for (int i = 1; i <= n; i++) {
            BIT[i] = 0;
        }
 
        // Count greater elements
        for (int i = 0; i < n; i++) {
        		//System.out.println("count greater");
            greater1[i] = i - getSum(BIT, arr[i]);
            System.out.println("current:" + arr[i]+" count greater:" + greater1[i]);
            updateBIT(BIT, n, arr[i], 1);
        }
 
        // Compute Inversion count using smaller[] and greater[]. 
        long invcount = 0;
        for (int i = 0; i < n; i++) {
            invcount += smaller1[i] * greater1[i];
        }
 
        return invcount;    	
    }
    
	public static void main(String[] args) {
		int[] a = {5,3,9,-2,10};				
		System.out.println("ans:" + countInv(a));
	}
}






