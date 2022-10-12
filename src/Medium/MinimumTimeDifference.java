package medium;

import java.util.List;
import java.util.stream.Collectors;

public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> minutes = timePoints.stream()
                .map(t -> 60 * Integer.parseInt(t.substring(0, 2)) + Integer.parseInt(t.substring(3)))
                .sorted()
                .collect(Collectors.toList());

        int res = minutes.get(0) + 24 * 60 - minutes.get(minutes.size() - 1);
        for (int i = 1; i < minutes.size(); i++) {
            res = Math.min(res, minutes.get(i) - minutes.get(i - 1));
        }

        return res;
    }
}
