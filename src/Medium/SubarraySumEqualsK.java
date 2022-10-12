package medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        if(nums.length < 1 || k < 1)
        	return 0;
        
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);
        int ans = 0;
        int sum = 0;
        
        for(int n : nums) {
        	sum += n;
        	ans += count.getOrDefault(sum - k, 0);
        	count.put(sum, count.getOrDefault(sum, 0) + 1);        	
        }
        
        return ans;
    }
}
