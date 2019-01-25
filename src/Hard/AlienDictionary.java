package Hard;

import java.util.*;

class AlienDictionary {
    private String alienOrder(String[] words) {
        if(words == null || words.length < 1)
        	return "";
        
        Map<Character, List<Character>> order = new HashMap<>();	// a -> b
        Set<Character> exist = new HashSet<>();
        int[] in_degree = new int[26];
        
        String prev = words[0];
        for(int i = 1; i < words.length; i++){
        	int a = 0, b = 0;
        	while(a < prev.length() && b < words[i].length() && prev.charAt(a) == words[i].charAt(b)){
        		a++;
        		b++;
        	}        	
        	if(a == prev.length() || b == words[i].length()){
        		prev = words[i];
        		continue;
        	}
        		        	
        	order.putIfAbsent(prev.charAt(a), new ArrayList<>());
        	order.get(prev.charAt(a)).add(words[i].charAt(b));
        	
        	exist.add(prev.charAt(a));
        	exist.add(words[i].charAt(b));
        	
        	prev = words[i];
        }                        
        
        if(exist.isEmpty())
        	return String.valueOf(words[0].charAt(0));
        
        for(List<Character> next:order.values()){
        	for(char c:next)
        		in_degree[c - 'a']++;        	
        }
        
        Queue<Character> queue = new LinkedList<>();        
        for(char c:exist){
        	if(in_degree[c - 'a'] == 0)
        		queue.add(c);        		
        }
        
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty())
        {
        	char cur = queue.poll();
        	sb.append(cur);
        	List<Character> next = order.get(cur);
        	if(next != null){
            	for(char c: next){
            		in_degree[c - 'a']--;
            		if(in_degree[c - 'a'] == 0)
            			queue.add(c);
            	}  
        	}      	        	
        }
        
        if(sb.length() != exist.size())
        	return "";
        
        return sb.toString();
    }
}









