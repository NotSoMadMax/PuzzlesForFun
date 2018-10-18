package Easy;

import java.util.HashMap;

public class TwoSum {
    private int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2)
            return null;

        HashMap<Integer, Integer> m = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            m.put(nums[i], i);
        }

        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++){
            if(m.containsKey(target - nums[i]) && m.get(target - nums[i]) != i){
                res[0] = i;
                res[1] = m.get(target - nums[i]);
                break;
            }
        }

        return res;
    }
}
