package Easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        if (S == null || S.isEmpty()) {
            return Collections.emptyList();
        }

        List<String> results = new ArrayList<>();
        permutate(S, 0, "", results);

        return results;
    }

    private void permutate(String s, int pos, String cur, List<String> results) {
        if (pos >= s.length()) {
            results.add(cur);
            return;
        }

        permutate(s, pos + 1, cur + Character.toLowerCase(s.charAt(pos)), results);
        if(Character.isLetter(s.charAt(pos))) {
            permutate(s, pos + 1, cur + Character.toUpperCase(s.charAt(pos)), results);
        }
    }
}
