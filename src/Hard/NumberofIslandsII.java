package Hard;

import java.util.*;

class NumberofIslandsII {
	class UF{
		int[] parent;
		int[] rank;
		int n;
		
		public UF(int size){
			this.parent = new int[size];
			this.rank = new int[size];
			this.n = 0;
			
			Arrays.fill(this.parent, -1);
		}
		
		public int find(int a){
			while(a != parent[a]){
				parent[a] = parent[parent[a]];	// path compression
				a = parent[a];
			}
			
			return a;
		}
			
		public void union(int a, int b){
			int a_root = find(a);
			int b_root = find(b);
			
			if(a_root == b_root)
				return;
			
			if(rank[a_root] > rank[b_root])
				parent[b_root] = a_root;
			else if(rank[a_root] < rank[b_root])
				parent[a_root] = b_root;
			else{
				parent[b_root] = a_root;
				rank[a_root]++;
			}
			
			n--;
		}
	}
	
	
	
    private List<Integer> numIslands2(int m, int n, int[][] positions) {
        UF uf = new UF(m*n);
        
        int[] row_change = {0, -1, 0, 1};
        int[] col_change = {-1, 0, 1, 0};
        
        List<Integer> res = new ArrayList<>();
        for(int[] land:positions)
        {
        	int r = land[0], c = land[1];
        	uf.parent[r*n+c] = r*n+c;
        	uf.n++;
        	
        	for(int i = 0; i < 4; i++)
        	{
        		int row = r + row_change[i];
        		int col = c + col_change[i];
        		
        		if(row < 0 || row >= m || col < 0 || col >= n)
        			continue;
        		
        		if(uf.parent[row*n+col] != -1)
        			uf.union(r*n+c, row*n+col);        		
        	}
        	
        	res.add(uf.n);
        }    	    
    	return res;
    }
    
}










