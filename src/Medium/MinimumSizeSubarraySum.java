package medium;

public class MinimumSizeSubarraySum {

    // Method 2: binary search, time limit exceeds
    private int minSubArrayLen2(int s, int[] nums) {
        if(nums == null || nums.length < 1)
            return 0;

        int len = nums.length;
        int[] prefix = new int[len + 1];
        for(int i = 1; i <= len; i++)
            prefix[i] = prefix[i-1] + nums[i=1];

        int res = len + 1;
        for(int i = 0; i <= len; i++){
            int right = findRight(i + 1, len, prefix[i] + s, prefix);
            if(right == len+1)  // cannot find anymore > s
                break;

            res = Math.min(res, right - 1);
        }

        return res == len + 1?0:res;
    }

    // the smallest bound that gives prefix[bound] >= target
    private static int findRight(int low, int high, int target, int[] prefix){
        while (low <= high){
            int mid = low + (high - low)/2;

            if(prefix[mid] >= target){
                high = mid - 1;
            }
            else
                low = mid + 1;
        }

        return low;
    }


    // Method 1: sliding window, 99%
    private int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length < 1)
            return 0;

        int left = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            while (sum >= s){
                res = Math.min(res, i - left + 1);
                sum -= nums[left++];
            }
        }

        return res==Integer.MAX_VALUE?0:res;
    }
}
