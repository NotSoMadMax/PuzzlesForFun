package Easy;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    // Method 1: array, fast
    private boolean canConstruct_fast(String ransomNote, String magazine) {
        if(ransomNote == null || ransomNote.isEmpty())
            return true;

        if(magazine == null || magazine.isEmpty())
            return false;

        if(magazine.length() < ransomNote.length())
            return false;

        int[] count = new int[26];
        for(char c:magazine.toCharArray()){
            count[c - 'a']++;
        }

        for(char c:ransomNote.toCharArray()){
            if(count[c - 'a'] == 0)
                return false;

            count[c - 'a']--;
        }

        return true;
    }

    // Method 2: map, slow
    private boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote == null || ransomNote.isEmpty())
            return true;

        if(magazine == null || magazine.isEmpty())
            return false;

        if(magazine.length() < ransomNote.length())
            return false;

        Map<Character, Integer> m = new HashMap<>();
        for(int i = 0; i < magazine.length(); i++){
            m.put(magazine.charAt(i), m.getOrDefault(magazine.charAt(i), 0) + 1);
        }

        for(int i = 0; i < ransomNote.length(); i++){
            if(!m.containsKey(ransomNote.charAt(i)) || m.get(ransomNote.charAt(i)) == 0)
                return false;
            m.put(ransomNote.charAt(i), m.get(ransomNote.charAt(i)) - 1);
        }

        return true;
    }
}
