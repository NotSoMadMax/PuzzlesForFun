package medium;

class ProductofArrayExceptSelf {

    // Method 1: two array
    private int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length < 1)
            return null;

        int len = nums.length;
        int[] left = new int[len];  // cumu product from the left
        left[0] = 1;
        int[] right = new int[len]; // cumu product from the right
        right[len - 1] = 1;

        for(int i = 1; i < len; i++){
            left[i] = left[i - 1]*nums[i - 1];
            right[len - 1 - i] = right[len - i]*nums[len - i];
        }

        int[] res = new int[len];
        for(int i = 0; i < len; i++)
            res[i] = left[i]*right[i];

        return res;
    }

    // Method 2: constant space
    private int[] productExceptSelf1(int[] nums) {
        if(nums == null || nums.length < 1)
            return null;

        int len = nums.length;
        int[] res = new int[len];
        res[0] = 1;

        for(int i = 1; i < len; i++)
            res[i] = res[i-1]*nums[i-1];

        int right = 1;  // culmu from the right
        for(int i = len - 1; i >= 0; i--)
        {
            res[i] = res[i] * right;
            right = right*nums[i];
        }

        return res;
    }
}
