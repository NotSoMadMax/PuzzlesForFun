package medium;

class WiggleSort {
    private void wiggleSort(int[] nums) {
        if(nums == null || nums.length < 1)
            return;

        for(int i = 0; i < nums.length - 1; i++){
            if(i % 2 == 0 && nums[i] > nums[i+1])
                swap(nums, i, i+1);
            else if(i % 2 != 0 && nums[i] < nums[i+1])
                swap(nums, i, i+1);
        }

        return;
    }

    private static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
