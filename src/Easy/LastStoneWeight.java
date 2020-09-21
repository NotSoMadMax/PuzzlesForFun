package Easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.stream(stones).forEach(pq::add);

        while (pq.size() > 1) {
            int diff = pq.poll() - pq.poll();
            if (diff > 0) {
                pq.add(diff);
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}
