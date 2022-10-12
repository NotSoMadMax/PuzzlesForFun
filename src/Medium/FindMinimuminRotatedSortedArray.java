package medium;

class FindMinimuminRotatedSortedArray {
    private int findMin(int[] nums) {
        if(nums == null || nums.length < 1)
            return -1;

        int len = nums.length;
        int left = 0, right = len - 1;

        if(nums[left] < nums[right])
            return nums[left];

        while (left < right){
            int mid = (right - left)/2 + left;

            if(nums[0] <= nums[mid])
                left = mid + 1;
            else if(nums[mid] < nums[len - 1])
                right = mid;
        }

        return nums[left];
    }
}
