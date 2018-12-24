package medium;

import java.util.*;

class CheapestFlightsWithinKStops {
	class Flight{
		int dest;
		int price;
		public Flight(int d, int p){
			this.dest = d;
			this.price = p;
		}
	}
	
	// Method 1: DFS
	int res;
    private int findCheapestPrice1(int n, int[][] flights, int src, int dst, int K) {
        if(flights == null || flights.length < 1 || n == 1 || src == dst)
        	return 0;
        
        Map<Integer, List<Flight>> graph = new HashMap<>();
        boolean[] visited = new boolean[100];
        for(int[] f:flights){
        	graph.putIfAbsent(f[0], new ArrayList<>());
        	graph.get(f[0]).add(new Flight(f[1], f[2]));
        }
        res = Integer.MAX_VALUE;
        search(graph, visited, src, dst, K, 0);
        
        return res==Integer.MAX_VALUE?-1:res;
    }
    
    private void search(Map<Integer, List<Flight>> graph, boolean[] visited, int cur_city, int dst, int k_left, int cur_cost){
    	if(cur_city == dst){
    		res = Math.min(res, cur_cost);
    		return;
    	}   
    	
    	if(visited[cur_city])
    		return;
    	
    	if(k_left < 0)
    		return;    	    	     	    	
    	
    	if(graph.containsKey(cur_city)){
	    	for(Flight f:graph.get(cur_city)){
	    		if(cur_cost + f.price > res)
	    			continue;
	    		
	    		search(graph, visited, f.dest, dst, k_left - 1, cur_cost + f.price);
	    	}    	
    	}
    }
    
    // Method 2: DP
    private int findCheapestPrice2(int n, int[][] flights, int src, int dst, int K) {
        if(flights == null || flights.length < 1 || n == 1 || src == dst)
        	return 0;
        
        int[][] dp = new int[K + 2][n];	// arrive city j with at most i flights
        for(int[] r:dp)
        	Arrays.fill(r, 10000000);
        dp[0][src] = 0;
        
        for(int x=1; x <= K+1; x++){
        	dp[x][src] = 0;
        	
        	for(int[] f:flights)
        	{
        		dp[x][f[1]] = Math.min(dp[x][f[1]], dp[x-1][f[0]] + f[2]);
        	}
        }
        
        return dp[K+1][dst]>=10000000?-1:dp[K+1][dst];	// K stops -> K+1 flights
    }
}






