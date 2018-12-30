package medium;

import java.util.*;


class AccountsMerge {
	
	class UF{
		int[] parent;
		int[] rank;
		int n;
		
		public UF(int size){
			this.parent = new int[size];
			this.rank = new int[size];
			this.n = size;
			
			for(int i = 0; i < n; i++)
				parent[i] = i;
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
	
	
    private List<List<String>> accountsMerge(List<List<String>> accounts) {
        if(accounts == null || accounts.isEmpty())
        	return Collections.emptyList();
        
        UF uf = new UF(10001);	// merge email if they belongs to the same account        
        Map<String, Integer> emailID = new HashMap<>();
        Map<String, String> emailName = new HashMap<>();
        int id = 0;
        
        for(List<String> a:accounts)
        {
        	String name = a.get(0);
        	String firstEmail = a.get(1);
        	for(int i = 1; i < a.size(); i++)
        	{
        		String email = a.get(i);
        		if(!emailID.containsKey(email))
        			emailID.put(email, id++);        		
        		
        		emailName.putIfAbsent(email, name);
        		
        		uf.union(emailID.get(firstEmail), emailID.get(email));
        	}
        }
        
        for(int i = 0; i < id; i++)
        	System.out.println(uf.parent[i]);
        
        Map<Integer, List<String>> ans = new HashMap<>();        
        for(String email:emailName.keySet()){
        	int root = uf.find(emailID.get(email));
        	ans.putIfAbsent(root, new ArrayList<>());
        	ans.get(root).add(email);
        }
                
        for(List<String> cur:ans.values()){
        	String name = emailName.get(cur.get(0));
        	Collections.sort(cur);
        	cur.add(0, name);
        }
        
        return new ArrayList<>(ans.values());
    }	
}












