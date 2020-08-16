package medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisiblebyK {
    public int subarraysDivByK(int[] a, int k) {
        if (a == null || a.length < 1) {
            return 0;
        }

        // sums[i]: sum from a[0] to a[i]
        int[] sums = new int[a.length];
        sums[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            sums[i] = a[i] + sums[i - 1];
        }

        Map<Integer, Integer> reminderCount = new HashMap<>();
        for (int s : sums) {
            int reminder = s % k;
            while (reminder < 0) {  // padding for negative numbers
                reminder += k;
            }
            reminderCount.put(reminder, reminderCount.getOrDefault(reminder, 0) + 1);
        }

        // calculate results
        int res = 0;
        for (int reminder : reminderCount.keySet()) {
            int count = reminderCount.get(reminder);
            if (reminder == 0) {
                res += count * (count - 1) / 2 + count;
            } else {
                res += count * (count - 1) / 2;
            }
        }

        return res;
    }
}
