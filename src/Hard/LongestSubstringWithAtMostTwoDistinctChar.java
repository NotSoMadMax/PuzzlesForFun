package Hard;

import java.util.*;

public class LongestSubstringWithAtMostTwoDistinctChar {
	// Method 2: sliding window, 97%
	private int lengthOfLongestSubstringTwoDistinct2(String s) {
        if(s == null || s.isEmpty())
            return 0;

        int res = 0;
        int left = 0, pre_change = -1;	// pre_change: last time meet a new char
        char[] cs = s.toCharArray();
        for(int i = 1; i < s.length(); i++){
        	if(cs[i] != cs[i-1]){	// meet a different char
        		if(pre_change >= 0 && cs[pre_change] != cs[i]){
        			res = Math.max(res, i - left);
        			left = pre_change + 1;
        		}
        		pre_change = i - 1;
        	}
        }
        
        return Math.max(res, s.length() - left);
	}


	
	// Method 1: Map, 10%
    private int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.isEmpty())
            return 0;

        int res = 0;

        char[] cs = s.toCharArray();
        Map<Character, Integer> m = new HashMap<>();
        int left = 0;

        for(int i = 0; i < s.length(); i++){
            m.put(cs[i], m.getOrDefault(cs[i], 0) + 1);

            if(m.size() > 2){
            		m.put(cs[left], m.get(cs[left]) - 1);
            		if(m.get(cs[left]) == 0)
            			m.remove(cs[left]);
            		left++;
            }
            res = Math.max(res, i - left + 1);
        }
        
        return res;
    }
}
