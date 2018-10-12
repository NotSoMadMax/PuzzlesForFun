package Easy;

import java.util.*;

public class DegreeOfAnArray {
    public static int findShortestSubArray(int[] nums) {
        if(nums == null || nums.length < 1)
            return 0;

        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> first_appear = new HashMap<>();

        int degree = 0;
        int shortest = 0;

        for(int i = 0; i < nums.length; i++){
            if(!count.containsKey(nums[i]))
                count.put(nums[i], 1);
            else
                count.put(nums[i], count.get(nums[i]) + 1);

            if(!first_appear.containsKey(nums[i]))  // first time this number appears
                first_appear.put(nums[i], i);

            if(count.get(nums[i]) > degree){
                shortest = i - first_appear.get(nums[i]) + 1;
                degree = count.get(nums[i]);
            } else if (count.get(nums[i]) == degree) {
                if(i - first_appear.get(nums[i]) + 1 < shortest)
                    shortest = i - first_appear.get(nums[i]) + 1;
            }
        }

        return shortest;
    }
}
