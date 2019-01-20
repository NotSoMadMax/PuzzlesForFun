package Easy;

import java.util.Arrays;
import java.util.PriorityQueue;

class KthLargestElementinaStream {
    class KthLargest {

        PriorityQueue<Integer> pq;
        int size;
        public KthLargest(int k, int[] nums) {
            this.pq = new PriorityQueue<>();
            this.size = k;

            for(int i = 0; i < nums.length; i++)
                pq.add(nums[i]);

            while (pq.size() > k)
                pq.poll();
        }

        public int add(int val) {
            pq.add(val);

            while (pq.size() > this.size)
                pq.poll();

            return pq.peek();
        }
    }
}
