package medium;

class WiggleSubsequence {

    // Greedy
    private int wiggleMaxLength_dp(int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;

        int len = nums.length;
        int[] up = new int[len];    // i - 1 goes up to i
        int[] down = new int[len];  // i - 1 goes down to i
        up[0] = 1;
        down[0] = 1;

        for(int i = 1; i < len; i++){
            if(nums[i] > nums[i-1]){
                up[i] = down[i-1] + 1;
                down[i] = down[i-1];
            }
            else if(nums[i] < nums[i-1]){
                down[i] = up[i-1] + 1;
                up[i] = up[i-1];
            }
            else{
                up[i] = up[i-1];
                down[i] = down[i-1];
            }
        }

        return Math.max(up[len-1], down[len-1]);
    }

}
