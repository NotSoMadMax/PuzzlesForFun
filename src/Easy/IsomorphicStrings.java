package Easy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    private boolean isIsomorphic(String s, String t) {
        if(s == null || t == null || s.isEmpty() || t.isEmpty())
        	return true;
        
        Map<Character, Character> smap = new HashMap<>();
        Map<Character, Character> tmap = new HashMap<>();
        
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        
        for(int i = 0; i < s.length(); i++){
        	if(!smap.containsKey(ss[i])){
        		smap.put(ss[i], tt[i]);
        		if(!tmap.containsKey(tt[i]))
        			tmap.put(tt[i], ss[i]);
        		else 
					return false;				
        	}
        	else {
				if(smap.get(ss[i]) != tt[i])
					return false;
			}
        }
        
        return true;
    }
}
