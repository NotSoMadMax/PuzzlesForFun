package medium;

import java.util.ArrayList;
import java.util.List;

public class PrintWordsVertically {
    public List<String> printVertically(String s) {
        String[] words = s.split("\\s+");
        int nOfWords = words.length;

        List<String> res = new ArrayList<>();
        int row = 0;
        while (nOfWords > 0) {
            int count = 0;  // number of words that has been appended at this row
            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                if (row >= word.length()) {
                    sb.append(" ");
                } else {
                    sb.append(word.charAt(row));

                    if (row == word.length() - 1) { // this word is done
                        nOfWords--;
                    } else {
                        count++;
                    }
                }

                if (count == nOfWords) {    // no need to append trailing zeros
                    break;
                }
            }
            res.add(sb.toString());
            row++;
        }
        return res;
    }
}
