package medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        int left = 0;
        int right = 0;
        Map<Character, Integer> lastLocation = new HashMap<>();

        int result = 1;
        while (right < s.length()) {
            if (lastLocation.getOrDefault(s.charAt(right), -1) >= left) {    // has duplicate in this window
                left = lastLocation.get(s.charAt(right)) + 1;
            }
            lastLocation.put(s.charAt(right), right);
            result = Math.max(result, right - left + 1);
            right++;
        }

        return result;
    }
}
