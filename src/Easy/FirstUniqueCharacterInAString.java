package Easy;

import java.util.*;

public class FirstUniqueCharacterInAString {

    private int firstUniqChar(String s) {
        if(s == null || s.length() < 1)
            return -1;

        if(s.length() == 1)
            return 0;

        int cur_best = s.length();  // left most unique char
        for(char c = 'a'; c <= 'z'; c++){
            int first_appear = s.indexOf(c);
            if(first_appear >= 0){  // contain this char
                if(first_appear == s.lastIndexOf(c) && first_appear < cur_best) // is unique
                    cur_best = first_appear;
            }
        }

        return cur_best==s.length()?-1:cur_best;
    }


    //Method 2: slower
    private int firstUniqChar2(String s) {
        if(s == null || s.length() < 1)
            return -1;

        if(s.length() == 1)
            return 0;

        char[] nums = s.toCharArray();
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        for(char c:nums)
            m.put(c, m.getOrDefault(c, 0) + 1);

        int i = 0;
        for(; i < nums.length; i++){
            if(m.get(nums[i]) == 1)
                break;
        }

        return i == nums.length?-1:i;
    }
}
