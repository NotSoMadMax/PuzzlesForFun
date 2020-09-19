package medium;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> ABSumCount = new HashMap<>();
        Map<Integer, Integer> CDSumCount = new HashMap<>();
        int len = A.length;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                ABSumCount.put(A[i] + B[j], ABSumCount.getOrDefault(A[i] + B[j], 0) + 1);
                CDSumCount.put(C[i] + D[j], CDSumCount.getOrDefault(C[i] + D[j], 0) + 1);
            }
        }

        int res = 0;
        for (Map.Entry e : ABSumCount.entrySet()) {
            if (CDSumCount.containsKey(- (int) e.getKey())) {
                res += CDSumCount.get(- (int) e.getKey()) * (int) e.getValue();
            }
        }

        return res;
    }
}
