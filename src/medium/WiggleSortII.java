package medium;

import java.util.Arrays;

class WiggleSortII {

    // space O(n)
    /*
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
    }*/


    // Method 2
    private void wiggleSort(int[] nums){
        if(nums == null || nums.length < 2)
            return;

        int median = findmedian(nums);
        int len = nums.length;

        int odd = 0, even = nums.length - 1;    // number of positions taken
        int cur = 0;

        // odd: 1, 3, 5,
        // even: 0, 2, 4, 6
        // cur:

        while (cur <= even){
            if(nums[cur] > median){
                swap(nums, transform(cur, nums), transform(odd, nums));     // swap to next available odd position
                cur++;
                odd++;
            } else if (nums[cur] < median){
                swap(nums, transform(cur, nums), transform(even, nums));    // swap to next available even position
                even--;
            } else {
                cur++;
            }
        }

    }


    //         raw: 0, 1, 2, 3, 4, 5, 6
    // transformed: 1, 3, 5, 0, 2, 4, 6
    private static int transform(int i, int[] nums){
        int len = nums.length;
        if(i < len/2)
            return i * 2 + 1; // odd sequence
        else
            return (i - len/2) * 2;  // even sequence
    }


    private static int findmedian(int[] nums){
        if(nums == null || nums.length < 1)
            return 0;

        int med = -1;
        int l = 0, r = nums.length - 1;
        int m = r/2;
        while (med != m){
            med = partition(l, r, nums);

            if(med < m) // median in right portion
                l = med + 1;
            else if(med > m)    // median in left portion
                r = med - 1;
            else
                break;      // med found
        }

        return nums[med];
    }


    private static int partition(int l, int r, int[] nums){
        if(l > r)
            return -1;

        int pivot = nums[r];
        int smaller = l - 1; // the last smaller position

        for(int i = l; i < r; i++){

            if(nums[i] <= pivot){
                smaller++;
                swap(nums, smaller, i);
            }
        }

        smaller++;
        swap(nums, smaller, r); // put pivot to the middle

        return smaller; // return the pivot position
    }


    private static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
