package medium;

public class FindPeakElement {
    private int findPeakElement(int[] nums) {
        if(nums == null || nums.length < 1)
            return 0;

        int l = 0, r = nums.length - 1;
        while (l < r){
            int mid = l + (r - l)/2;
            if(nums[mid] < nums[mid + 1])
                l = mid + 1;
            else
                r = mid;
        }

        return r;
    }
}
