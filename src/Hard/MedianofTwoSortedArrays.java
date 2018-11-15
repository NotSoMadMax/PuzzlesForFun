package Hard;

public class MedianofTwoSortedArrays {
    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int first = (m + n + 1)/2, second = (m + n + 2)/2;  // the middle numbers, will be the same if m + n is odd

        return (find(nums1, 0, nums2, 0, first) + find(nums1, 0, nums2, 0, second))/2.0;
    }

    /*
    i, j : current starting index
    k: looking for the kth number
     */
    private static int find(int[] nums1, int i, int[] nums2, int j, int k){
        if(i >= nums1.length)   // treat nums1 as an empty array
            return nums2[j + k -1]; // return kth value in nums2
        if(j >= nums2.length)
            return nums1[i + k - 1];

        if(k == 1)
            return Math.min(nums1[i], nums2[j]);

        // the two medians of both array
        int mid1 = Integer.MAX_VALUE;
        if(i + k/2 - 1 < nums1.length)
            mid1 = nums1[i + k/2 - 1];

        int mid2 = Integer.MAX_VALUE;
        if(j + k/2 - 1 < nums2.length)
            mid2 = nums2[j + k/2 - 1];

        if(mid1 < mid2){    // will not be in first part of nums1
            return find(nums1, i + k/2, nums2, j, k - k/2);
        } else {    // will not be in the first part of nums2
            return find(nums1, i, nums2, j + k/2, k - k/2);
        }
    }
}
