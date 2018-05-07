package Easy;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueChar {
    static String firstUniqueChar(String input) {
    		int len = input.length();
    		if (len < 1 || input == null)	return "";
    		
    		Map<Character, Integer> dic = new HashMap<>();
    		char[] chars = input.toCharArray();
    		for (char c:chars){
    			if (dic.containsKey(c))
    				dic.put(c, dic.get(c) + 1);
    			else
    				dic.put(c, 1);
    		}
    		
    		for (char c:chars){
    			if (dic.get(c) == 1)
    				return Character.toString(c);
    		}
    		return "";
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
