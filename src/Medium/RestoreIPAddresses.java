package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RestoreIPAddresses {
	
    private static List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4)
        		return Collections.emptyList();
        
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < s.length() - 3 && i <= 3; i++){
        		String s1 = s.substring(0, i+1);
        		if(!valid(s1))
        			break;
        		
        		for(int j = i + 1; j < s.length() - 2 && j <= i+3; j++){
        			String s2 = s.substring(i+1, j+1);
        			if(!valid(s2))
        				break;
        			
        			for (int k = j + 1; k < s.length() - 1 && k <= j+3; k++){
        				String s3 = s.substring(j + 1, k+1), s4 = s.substring(k+1, s.length());
        				if(valid(s3) && valid(s4))
        					result.add(s1 + "." + s2 + "." + s3 + "." + s4);
        			}
        		}
        }
        
        return result;
    }
    
    private static boolean valid(String s){
    		if(s == null || s.length() < 1 || s.length() > 3)
    			return false;
    		
    		if (s.charAt(0) == '0' && s.length() > 1)
    			return false;
    		if (Integer.parseInt(s) > 255)
    			return false;
    		
    		return true;
    }
    
    public static void main(String[] args){
    		String s = "0279245587303";
    		List<String> res = restoreIpAddresses(s);
    		System.out.println(res);
    }
    
}
