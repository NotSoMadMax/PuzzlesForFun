package Hard;

import java.util.*;

class AutocompleteSystem {
    Map<String, Integer> counts;
    String cur_input;

    public AutocompleteSystem(String[] sentences, int[] times) {
        counts = new TreeMap<>();
        cur_input = "";
    }

    public List<String> input(char c) {
        if(c == '#'){
            counts.put(cur_input, counts.getOrDefault(cur_input, 0) + 1);
            cur_input = "";
            return Collections.emptyList();
        }

        cur_input += String.valueOf(c);
        List<String> res = new ArrayList<>();

        return res;
    }
}

public class DesignSearchAutocompleteSystem {

}
