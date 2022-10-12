package medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class AvoidFloodinTheCity {
    public int[] avoidFlood(int[] rains) {
        int[] nextRainDay = new int[rains.length]; // next rain day of the lake
        Map<Integer, Integer> rainDays = new HashMap<>();   // lake -> closest rain day in the future during loop, helper map
        for (int day = rains.length - 1; day >= 0; day--) {
            int futureRainDay = rainDays.getOrDefault(rains[day], Integer.MAX_VALUE);   // previously seen rain day
            nextRainDay[day] = futureRainDay;
            rainDays.put(rains[day], day);
        }

        PriorityQueue<int[]> filledLakesNextRain = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); // a[0]: lake, a[1]: next rain day
        Set<Integer> filledLakes = new HashSet<>();
        int[] res = new int[rains.length];

        for (int day = 0; day < rains.length; day++) {
            int lake = rains[day];

            if (lake != 0) { // it's a rainy day
                if (filledLakes.contains(lake)) { // it will flood
                    return new int[0];
                }
                filledLakes.add(lake);
                filledLakesNextRain.add(new int[]{lake, nextRainDay[day]});
                res[day] = -1;
            } else {    // a no-rain day, choose dry a lake
                if (!filledLakesNextRain.isEmpty()) {
                    int[] lakeToDry = filledLakesNextRain.poll();
                    filledLakes.remove(lakeToDry[0]);
                    res[day] = lakeToDry[0];
                } else {    // all lake empty, drain a random one
                    res[day] = 1;
                }
            }
        }

        return res;
    }
}
