package Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NumberofGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> equalIndices = new HashMap<>();
        for (int num : nums) {
            equalIndices.put(num, equalIndices.getOrDefault(num, 0) + 1);
        }
        return equalIndices.values().stream().reduce(0, (total, i) -> total + i * (i - 1) / 2);
        // return equalIndices.values().stream().mapToInt(i -> i * (i - 1) / 2).sum();
    }
}
