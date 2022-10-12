package medium;

import java.util.ArrayList;
import java.util.List;

public class CamelcaseMatching {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        for (String s : queries) {
            res.add(isMatch(s, pattern));
        }
        return res;
    }

    private boolean isMatch(String word, String pattern) {
        int posPattern = 0;
        int posWord = 0;
        while (posPattern < pattern.length() && posWord < word.length()) {
            if (word.charAt(posWord) == pattern.charAt(posPattern)) {
                posPattern++;
                posWord++;
            } else {
                if (Character.isUpperCase(word.charAt(posWord))) {
                    return false;
                }
                posWord++;
            }
        }

        // Some characters in pattern have no match
        if (posPattern < pattern.length()) {
            return false;
        }

        // if there's upper case left after finished matching pattern
        while (posWord < word.length()) {
            if (Character.isUpperCase(word.charAt(posWord++))) {
                return false;
            }
        }
        return true;
    }
}
