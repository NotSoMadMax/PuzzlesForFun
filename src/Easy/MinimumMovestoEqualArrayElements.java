package Easy;

import java.util.Arrays;

public class MinimumMovestoEqualArrayElements {

    // sort O(nlogn)
    private int minMoves(int[] nums) {
        if(nums == null || nums.length < 2)
            return 0;

        Arrays.sort(nums);
        int res = 0;
        for(int i = 1; i < nums.length; i++)
            res += nums[i] - nums[0];

        return res;
    }

    // or better solution: just need to loop and find the min (O(n) time)
}
