package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PalidromePartioning {

    public List<List<String>> partition(String s) {
        if(s == null || s.length() < 1) {
            return Collections.emptyList();
        }

        int[][] records = new int[s.length()][s.length()];  // -1 for false, 0 for initial, 1 for true

        List<List<String>> results = new ArrayList<>();
        search(results, new ArrayList<>(), s, 0, records);

        return results;
    }

    private void search(List<List<String>> results, List<String> curPartition, String s, int start, int[][] records) {
        if(start >= s.length()) {
            results.add(new ArrayList<>(curPartition));     // Make a copy
            return;
        }

        for(int end = start + 1; end <= s.length(); end++) {
            if(isPalidrome(s, start, end - 1, records)) {
                curPartition.add(s.substring(start, end));
                search(results, curPartition, s, end, records);
                curPartition.remove(curPartition.size() - 1);
            }
        }
    }

    // Start and end are inclusive
    private boolean isPalidrome(String s, int start, int end, int[][] records) {
        if(records[start][end] != 0) { // Opportunistically reduce redundant computation
            return records[start][end] == 1;
        }

        while (start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                records[start][end] = -1;
                return false;
            }
            start++;
            end--;
        }
        records[start][end] = 1;
        return true;
    }
}