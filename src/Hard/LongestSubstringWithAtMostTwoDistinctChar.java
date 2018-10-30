package Hard;

import java.util.*;

public class LongestSubstringWithAtMostTwoDistinctChar {
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

            }

        }

    }
}
