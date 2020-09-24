package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class LongestIncreasingSubsequence {

    // dp, n square solution
    private int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;

        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++){
           dp[i] = 1;
        }
        int result = 1;

        for(int i = 1; i < len; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            if (dp[i] > result)
                result = dp[i];
        }

        return result;
    }


    // nlogn solution
    private int sol2(int[] nums){
        if (nums == null || nums.length < 1)
            return 0;

        int len = nums.length;
        List<Integer> seq = new ArrayList<>();
        seq.add(nums[0]);

        for(int i = 1; i < len; i++){
            if(nums[i] < seq.get(0))
                seq.set(0, nums[i]);
            else if (nums[i] > seq.get(seq.size() - 1))
                seq.add(nums[i]);
            else{       // find the first in seq that is larger than nums[i]
                int left = 0, right = seq.size() - 1, mid = 0;
                while(left < right){
                    mid = left + (right - left)/2;
                    if(seq.get(mid) < nums[i])
                        left = mid + 1;
                    else
                        right = mid;
                }
                seq.set(right, nums[i]);
            }
        }

        return seq.size();
    }

    // 2020
    // DP
    public int lengthOfLIS2020(int[] nums) {
        if(nums == null || nums.length < 1) {
            return 0;
        }
        int res = 1;
        int[] dp = new int[nums.length];    // the LIS that ends at i
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
