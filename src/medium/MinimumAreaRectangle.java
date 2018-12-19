package medium;

import java.util.*;

public class MinimumAreaRectangle {
	
	// Method 1: column by column
    public int minAreaRect1(int[][] points) {
        if(points == null || points.length < 1 || points[0] == null || points[0].length < 1)
        	return 0;
    	
        Map<Integer, List<Integer>> xm = new TreeMap<>();
        for(int[] p:points){
        	xm.putIfAbsent(p[0], new ArrayList<>());
        	xm.get(p[0]).add(p[1]);
        }
        
        Map<String, Integer> memo = new HashMap<>(); // "y1,y2" -> x, the most previous y1,y2 pair
        int res = Integer.MAX_VALUE;
        for(int x:xm.keySet()){
        	List<Integer> ys = xm.get(x);
        	Collections.sort(ys);
        	for(int i = 0; i < ys.size(); i++){
        		for(int j = i + 1; j < ys.size(); j++){
        			int y1 = ys.get(i), y2 = ys.get(j);
        			String pair = y1 + "," + y2;
        			
        			if(memo.containsKey(pair)){
        				res = Math.min(res, (x - memo.get(pair)) * (y2 - y1));
        			}   
        			memo.put(pair, x);        			        				        			
        		}
        	}        	
        }
    	
    	return res == Integer.MAX_VALUE?0:res;
    }
    
    // Method 2: diagonal
    public int minAreaRect2(int[][] points) {
        if(points == null || points.length < 1 || points[0] == null || points[0].length < 1)
        	return 0;
        
        Set<Integer> s = new HashSet<>();
        for(int[] p:points){
        	s.add(Arrays.hashCode(p));
        }
        
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < points.length; i++)
        {
        	for(int j = i + 1; j < points.length; j++)
        	{
        		if(points[i][0] != points[j][0] && points[i][1] != points[j][1])	// is diagonal
        		{
        			int[] p1 = new int[]{points[j][0],points[i][1]};
        			int[] p2 = new int[]{points[i][0],points[j][1]};         			
        			        			
        			if(s.contains(Arrays.hashCode(p1)) && s.contains(Arrays.hashCode(p2)))
        				res = Math.min(res, Math.abs(points[i][0] - points[j][0])*Math.abs(points[i][1] - points[j][1]));        			
        		}
        	}
        }
    	
    	return res == Integer.MAX_VALUE?0:res;
    }
}












