package medium;

import java.util.*;

class AllNodesDistanceKinBinaryTree {
	// Method 1: Graph + BFS
    private List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<Integer, List<Integer>> neighbors = new HashMap<>();        
    	
        buildGraph(neighbors, root, null);
        
        // BFS search in graph
        Queue<Integer> q = new ArrayDeque<>();
        q.add(target.val);
        boolean[] visited = new boolean[501];        
        visited[target.val] = true;
        
        List<Integer> res = new ArrayList<>();
        int dist = 0;
        while(!q.isEmpty() && dist <= K){
        	int cur_size = q.size();
        	
        	while(cur_size > 0){
        		int cur = q.poll();
        		if(dist == K)
        			res.add(cur);
        		
        		for(int child:neighbors.get(cur)){
        			if(visited[child])
        				continue;
        			q.add(child);
        			visited[child] = true;
        		}
        		cur_size--;
        	}
        	
        	dist++;       	
        }
        
    	return res;
    }	
    
    private void buildGraph(Map<Integer, List<Integer>> neighbors, TreeNode cur, TreeNode parent){
    	if(cur == null)
    		return;
    	
    	List<Integer> nei = new ArrayList<>();
    	if(parent != null)
    		nei.add(parent.val);
    	if(cur.left != null)
    		nei.add(cur.left.val);
    	if(cur.right != null)
    		nei.add(cur.right.val);
    	
    	neighbors.put(cur.val, nei);
    	
    	buildGraph(neighbors, cur.left, cur);
    	buildGraph(neighbors, cur.right, cur);
    }
    
    
}














