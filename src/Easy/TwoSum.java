package Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    public int[] twoSum2021Hash(int[] nums, int target) {
        Map<Integer, Integer> location = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            location.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++) {
            int remain = target - nums[i];
            if(location.containsKey(remain) && location.get(remain) != i) {
                return new int[]{i, location.get(remain)};
            }
        }
        return null;
    }

    public int[] twoSum2021Sort(int[] nums, int target) {
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);
        int left = 0;
        int right = sortedNums.length - 1;

        while(left < right) {
            int sum = sortedNums[left] + sortedNums[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                return findIndices(sortedNums[left], sortedNums[right], nums);
            }
        }
        return null;
    }

    public int[] findIndices(int num1, int num2, int[] nums) {
        int[] response = new int[2];
        int numFound = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == num1 || nums[i] == num2) {
                response[numFound++] = i;
            }
        }
        return response;
    }
}
