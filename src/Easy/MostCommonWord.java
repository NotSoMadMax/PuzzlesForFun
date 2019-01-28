package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        if(paragraph == null || paragraph.isEmpty())
        	return paragraph;
        
        // String[] words = paragraph.toLowerCase().split("\\s|!|\\?|'|,|;|\\.");
        String[] words = paragraph.toLowerCase().split("[ !?',;.]+"); // faster
        
        Map<String, Integer> count = new HashMap<>();
        // Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Set<String> ban = new HashSet<>();
        for(String w:banned)    // faster
            ban.add(w);
        
        String most = "";
        int max = 0;
        
        for(String w:words){
        	if(w.isEmpty())
        		continue;
        	
        	if(!ban.contains(w)){
        		count.put(w, count.getOrDefault(w, 0) + 1);
        		
        		if(count.get(w) > max){
        			most = w;
        			max = count.get(w);
        		}
        	}
        }
        
        return most;
    }
}
