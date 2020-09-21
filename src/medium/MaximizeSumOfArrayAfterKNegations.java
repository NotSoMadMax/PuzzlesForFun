package medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximizeSumOfArrayAfterKNegations {
    public int largestSumAfterKNegations(int[] A, int K) {
        int sum = Arrays.stream(A).sum();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.stream(A).forEach(pq::add);

        while (K-- > 0) {
            int toFlip = pq.poll();
            sum -= 2 * toFlip;
            pq.add(-toFlip);
        }

        return sum;
    }
}
