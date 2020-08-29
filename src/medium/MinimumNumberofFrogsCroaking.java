package medium;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberofFrogsCroaking {
    public int minNumberOfFrogs(String croakOfFrogs) {
        if (croakOfFrogs == null || croakOfFrogs.length() < 5) {
            return -1;
        }

        Map<Character, Integer> order = new HashMap<>();
        order.put('c', 0);
        order.put('r', 1);
        order.put('o', 2);
        order.put('a', 3);
        order.put('k', 4);

        int frog = 0;   // current number of frogs
        int maxFrog = 0;
        int[] count = new int[5];   // number of frogs that are at that progress
        for (char alpha : croakOfFrogs.toCharArray()) {
            count[order.get(alpha)]++;
            if ('c' == alpha) { // need a another frog to start
                frog++;
                maxFrog = Math.max(maxFrog, frog);
            } else {
                if (count[order.get(alpha) - 1] == 0) { // no frog can progress to current position
                    return -1;
                }

                count[order.get(alpha) - 1]--;  // progress from last position to this position

                if ('k' == alpha) {  // one frog finish
                    frog--;
                }
            }
        }

        if (frog != 0) {    // some frogs are not done yet
            return -1;
        } else {
            return maxFrog;
        }
    }
}
