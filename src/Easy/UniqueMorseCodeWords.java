package Easy;

import java.util.*;

public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        if(words == null || words.length < 1)
            return 0;

        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> s = new HashSet<String>();

        for(String w:words){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < w.length(); i++)
                sb.append(codes[w.charAt(i) - 'a']);

            s.add(sb.toString());
        }

        return s.size();
    }
}
