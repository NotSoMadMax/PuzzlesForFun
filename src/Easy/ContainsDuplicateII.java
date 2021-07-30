package Easy;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> locations = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(locations.containsKey(nums[i]) && i - locations.get(nums[i]) <= k) {
                return true;
            } else {
                locations.put(nums[i], i);
            }
        }

        return false;
    }
}
