class Solution {
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        while(true) {
            int pivot = partition(nums, left, right);
            if(pivot < nums.length - k) {
                left = pivot + 1;
            } else if(pivot > nums.length - k) {
                right = pivot - 1;
            } else {
                return nums[pivot];
            }
        }
    }
    
    private int partition(int[] nums, int left, int right) {
        int pivot=  nums[left];
        int l = left + 1;
        int r = right;
        while(l <= r) {
            if(nums[l] > pivot && nums[r] < pivot) {
                swap(nums, l++, r--);
            }
            if(nums[l] <= pivot){
                l++;
            }
            if(nums[r] >= pivot) {
                r--;
            }
        }
        swap(nums, left, r);
        return r;
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }
}