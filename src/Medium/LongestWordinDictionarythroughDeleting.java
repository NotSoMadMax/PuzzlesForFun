package medium;

import java.util.*;

class ListCompare implements Comparator<String>{
	public int compare(String a, String b){
		if(a.length() > b.length())
			return -1;
		else if(a.length() < b.length())
			return 1;
		else
			return a.compareTo(b);
	}
}

public class LongestWordinDictionarythroughDeleting {
    private String findLongestWord(String s, List<String> d) {
        if(d == null || d.size() < 1)
        	return "";
        
        Collections.sort(d, new ListCompare());
    	
        String res = "";        
        for(String cur:d){
        	if(delete(s, cur)){
        		res = cur;
        		break;
        	}        		
        }
        
    	return res;
    }
    
    
    private boolean delete(String s, String cur){    	
    	int j = 0;
    	for(int i = 0; i < cur.length(); i++){
    		while(j < s.length() && cur.charAt(i) != s.charAt(j))
    			j++;
    		
    		if(j == s.length())
    			return false;
    		j++;
    	}    	
    	
    	return true;
    }
    
}
