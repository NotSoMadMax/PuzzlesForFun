package Easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<String> commonChars(String[] a) {
        if (a == null || a.length < 1) {
        	return Collections.emptyList();
        }

        int len = a.length;
        int[][] count = new int[26][len];

        for(int i = 0; i < len; i++) {
        	for(char c : a[i].toCharArray()) {
        		count[c - 'a'][i]++;
        	}
        }

        List<String> result = new ArrayList<>();
        for(int i = 0; i < 26; i++) {
            int minCount = findNonZeroMin(count[i]);
            for(int j = 0; j < minCount; j++) {
                result.add(String.valueOf((char) ('a' + i)));
            }
        }

        return result;
    }

    private int findNonZeroMin(int[] charCount) {
        int min = 100;
        for(int i = 0; i < charCount.length; i++) {
            if (charCount[i] == 0) {
                return 0;
            }
            if(charCount[i] < min) {
                min = charCount[i];
            }
        }
        return min;
    }
}