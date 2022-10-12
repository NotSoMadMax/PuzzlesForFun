package medium;

import java.util.*;

public class LongestSubstringWithoutRepeatChar {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() < 1)
            return 0;

        int len = s.length();
        if(len == 1)
            return 1;

        int left = 0;
        int best = 1;

        // char -> last appear position
        Map<Character, Integer> m = new HashMap<>();
        m.put(s.charAt(0), 0);

        for(int i = 1; i < len; i++){
            char cur = s.charAt(i);

            if(m.containsKey(cur)){     // appear in the past
                if(m.get(cur) >= left){
                    left = m.get(cur) + 1;
                }
            }
            m.put(cur, i);
            if(i - left + 1 > best)
                best = i - left + 1;
        }

        return best;
    }
}
