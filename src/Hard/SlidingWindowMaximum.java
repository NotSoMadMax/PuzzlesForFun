package Hard;

import java.util.*;

public class SlidingWindowMaximum {

    // Method 1: priority queue, O(nk) time. 28%
    private int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length < 1)
            return new int[0];

        int len = nums.length;
        int[] res = new int[len - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < k; i++){
            pq.add(nums[i]);
        }
        res[0] = pq.peek();

        int j = 1;
        for(int i = k; i < len; i++){
            pq.remove(nums[i - k]);     // removing element takes linear time
            pq.add(nums[i]);
            res[j++] = pq.peek();
        }

        return res;
    }


    // Method 2: double linked list (deque), 62%
    private int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums == null || nums.length < 1)
            return new int[0];

        int len = nums.length;
        int[] res = new int[len - k + 1];

        Deque<Integer> dq = new LinkedList<>(); // store the index, but order by values
        int j = 0;
        for (int i = 0; i < len; i++){
            if(!dq.isEmpty() && dq.peekFirst() <= i - k) // the head is the left of current window, should be removed
                dq.pollFirst();

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i])  // remove all that are smaller than the new element
                dq.pollLast();

            dq.addLast(i);
            if(i >= k - 1)
                res[j++] = nums[dq.peekFirst()];
        }

        return res;
    }
}
