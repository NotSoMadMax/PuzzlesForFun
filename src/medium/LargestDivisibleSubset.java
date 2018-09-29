package medium;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class LargestDivisibleSubset {
    private List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length < 1)
            return Collections.emptyList();

        int len = nums.length;
        int[] dp = new int[len];
        int[] next_num = new int[len];
        int cur_max = 0;
        int cur_start = 0;

        Arrays.sort(nums);

        for(int i = len - 2; i >= 0; i--){
            for(int j = i + 1; j < len; j++){
                if(nums[j] % nums[i] == 0 && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    next_num[i] = j;
                    if(dp[i] > cur_max){
                        cur_max = dp[i];
                        cur_start = i;
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i <= cur_max; i++){
            result.add(nums[cur_start]);
            cur_start = next_num[cur_start];
        }

        return result;
    }
}
