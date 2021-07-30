package Easy;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for(int num : nums) {
            if (counter.containsKey(num)) {
                return true;
            } else {
                counter.put(num, 1);
            }
        }
        return false;
    }
}
