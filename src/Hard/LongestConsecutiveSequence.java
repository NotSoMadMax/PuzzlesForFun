package Hard;

import java.util.HashSet;
import java.util.Set;

class LongestConsecutiveSequence {
    private int longestConsecutive(int[] nums) {
        if(nums == null || nums.length < 1)
            return 0;

        Set<Integer> s = new HashSet<>();
        for(int i:nums)
            s.add(i);

        int result = 0;
        for(int i = 0; i < nums.length; i++){
            int l = nums[i], r = nums[i];

            if(!s.contains(nums[i]))
                continue;

            while (s.contains(l - 1)){
                l = l - 1;
                s.remove(l);
            }

            while (s.contains(r + 1)){
                r = r + 1;
                s.remove(r);
            }

            if(r - l > result)
                result = r - l;
        }

        return result + 1;
    }
}
