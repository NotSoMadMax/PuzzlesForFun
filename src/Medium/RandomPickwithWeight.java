package medium;

import java.util.Random;

class Solution {
	int totalWeight;
	int[] preSum;
	Random rand = new Random();
	
    public Solution(int[] w) {
        totalWeight = 0;
        preSum = new int[w.length];
        for(int i = 0; i < w.length; i++){
        	totalWeight += w[i];
        	preSum[i] = totalWeight;
        }
    }
    
    public int pickIndex() {
        int pick = rand.nextInt(totalWeight) + 1;	// nextInt(n) : [0, n)
        int l = 0, h = preSum.length - 1;
        
        while(l < h){
        	int m = (l + h)/2;
        	if(pick <= preSum[m])
        		h = m;
        	if(preSum[m] < pick)
        		l = m + 1;
        }
        
        return l;
    }
}


class RandomPickwithWeight {

}
