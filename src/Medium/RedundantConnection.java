package medium;

import java.util.*;

public class RedundantConnection {
	ArrayList<Integer>[] neighbors;	
	
    private int[] findRedundantConnection(int[][] edges) {
        if(edges == null || edges.length < 1 || edges[0] == null || edges[0].length < 1)
        	return new int[0];
        
        neighbors = new ArrayList[1001];	//given at most 1000 nodes
        for(int i = 0; i < 1001; i++)
        	neighbors[i] = new ArrayList<>();
        
        for(int[] e:edges){
        	Set<Integer> visited = new HashSet<>();
        	
        	if(!neighbors[e[0]].isEmpty() && !neighbors[e[1]].isEmpty()){
        		if(search(visited, e[0], e[1]))
        			return e;
        	}
        	
        	neighbors[e[0]].add(e[1]);
        	neighbors[e[1]].add(e[0]);
        }
                        
        return null;
    }
    
    
    private boolean search(Set<Integer> visited, int cur, int target){
    	if(visited.contains(cur))
    		return false;
    	    	
    	if(cur == target)
    		return true;
    	visited.add(cur);
    	for(int n:neighbors[cur]){
    		if(search(visited, n, target))
    			return true;
    	}
    	
    	return false;
    }
}
