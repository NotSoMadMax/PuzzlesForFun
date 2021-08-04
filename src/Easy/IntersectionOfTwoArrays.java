package Easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> result = new LinkedList<>();
        int i = 0, j = 0;
        while(i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                if (result.size() == 0 || nums1[i] != result.get(result.size() - 1)) {
                    result.add(nums1[i]);
                }
                i++;
                j++;
            }
        }

        int[] response = new int[result.size()];
        for(int x = 0; x < response.length; x++) response[x] = result.get(x);
        return response;
    }
}
