package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindandReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new LinkedList<>();
        for (String word : words) {
            if (isMatch(word.toCharArray(), pattern.toCharArray())) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean isMatch(char[] word, char[] pattern) {
        if (word.length != pattern.length) {
            return false;
        }

        Map<Character, Character> mapping = new HashMap<>();
        Map<Character, Character> beMapped = new HashMap<>();
        for (int i = 0; i < word.length; i++) {
            char mapTo = mapping.getOrDefault(word[i], '0');
            if (mapTo == '0') {
                if (beMapped.containsKey(pattern[i])) {
                    return false;
                }
                mapping.put(word[i], pattern[i]);
                beMapped.put(pattern[i], word[i]);
            } else if (mapTo != pattern[i]) {
                return false;
            }
        }
        return true;
    }
}
