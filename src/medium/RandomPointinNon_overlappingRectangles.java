package medium;

import java.util.Random;

public class RandomPointinNon_overlappingRectangles {
	int[][] rs;
	int[] sums;		// prefix sum of area
	int total;		// total area
	Random rand =  new Random();
	
    public RandomPointinNon_overlappingRectangles(int[][] rects) {
        if(rects == null || rects.length < 1 || rects[0] == null || rects[0].length < 1)
        	return;
        
    	int len = rects.length;
        rs = rects;
        sums = new int[len];
        total = 0;
        for(int i = 0; i < len; i++){
        	total += (rects[i][2] - rects[i][0] + 1)*(rects[i][3] - rects[i][1] + 1);
        	sums[i] = total;
        }    
        
    }
    
    public int[] pick() {
        int p = rand.nextInt(total);
        
        int l = 0, h = sums.length - 1;
        int mid;
        while(l < h){
        	mid = l + (h - l)/2;
        	if(sums[mid] <= p)
        		l = mid + 1;
        	else
        		h = mid;
        }
        
        int[] cur_rect = rs[l];
        int width = cur_rect[2] - cur_rect[0] + 1;
        int height = cur_rect[3] - cur_rect[1] + 1;        

        int base = sums[l] - width*height;
        return new int[]{cur_rect[0] + (p - base)%width, cur_rect[1] + (p - base)/width}; 
    }
}






