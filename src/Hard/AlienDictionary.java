package Hard;

import java.util.*;

class AlienDictionary {
    private String alienOrder(String[] words) {
        if(words == null || words.length < 1)
        	return "";
        
        Map<Character, List<Character>> order = new HashMap<>();	// a -> b
        Set<Character> exist = new HashSet<>();
        int[] in_degree = new int[26];
        
        
        for(String w:words){
        	for(char c:w.toCharArray())
        		exist.add(c);
        }
                
        for(int i = 1; i < words.length; i++)
        {
        	int len = Math.min(words[i-1].length(), words[i].length());
        	for(int j = 0; j < len; j++){
        		if(words[i-1].charAt(j) != words[i].charAt(j)){
        			order.putIfAbsent(words[i-1].charAt(j), new ArrayList<>());
        			order.get(words[i-1].charAt(j)).add(words[i].charAt(j));
        			break;
        		}
        	}        	        	
        }                        
        
        for(List<Character> next:order.values()){
        	for(char c:next)
        		in_degree[c - 'a']++;        	
        }
        
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();        
        for(char c:exist){
        	if(in_degree[c - 'a'] == 0){
        		queue.add(c);      
        		sb.append(c);
        	}        			
        }
                
        while(!queue.isEmpty())
        {
        	char cur = queue.poll();        	
        	List<Character> next = order.get(cur);
        	if(next != null){
            	for(char c: next){
            		in_degree[c - 'a']--;
            		if(in_degree[c - 'a'] == 0){
            			queue.add(c);
            			sb.append(c);
            		}            			
            	}  
        	}      	        	
        }
        
        if(sb.length() != exist.size())
        	return "";
        
        return sb.toString();
    }
}









