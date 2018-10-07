package medium;

import java.util.Arrays;

class WiggleSortII {
    private void wiggleSort(int[] nums) {
        if(nums == null || nums.length < 1)
            return;

        int len = nums.length;
        if(len == 1)
            return;

        Arrays.sort(nums);
        int[] res = new int[len];

        int l = (len + 1)/2 - 1, r = len - 1;
        for(int i = 0; i < len; i++){
            if(i % 2 == 0){
                res[i] = nums[l];
                l--;
            } else {
                res[i] = nums[r];
                r--;
            }
        }

        for(int i = 0; i < len; i++)
            nums[i] = res[i];

        return;
    }

}
