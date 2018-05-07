package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    static private List<List<String>> groupAnagrams(String[] strs) {
    		int len = strs.length;
    		if (len < 1 || strs == null)	return Collections.emptyList();
    		List<List<String>> result= new ArrayList<List<String>>();
    		Map<String, List<String>> m = new HashMap<String, List<String>>();
    		
    		for (String s:strs){
    			char[] cur = s.toCharArray();
    			Arrays.sort(cur);
    			String key = new String(cur);
    			if (!m.containsKey(key))
    				m.put(key, new ArrayList<String>());	//create a new cluster
    			m.get(key).add(s);
    		}
    		
    		for (List<String>  ans: m.values()){
    			result.add(ans);
    		}
    		return result;
    }
    
    public static void main(String[] args){
    		String[] test = {"abc", "bca", "cab",
    						"qia", "iqan","aqni",
    						"lala","alla"};
    		List<List<String>> anagram = groupAnagrams(test);
    		System.out.println(anagram);
    		return;
    }
}
