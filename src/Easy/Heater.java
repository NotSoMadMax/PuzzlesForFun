package Easy;

import java.util.Arrays;

public class Heater {
    public int findRadius(int[] houses, int[] heaters) {
        if(houses == null || heaters == null || houses.length < 1 || heaters.length < 1)
            return 0;

        Arrays.sort(houses);
        Arrays.sort(heaters);
        int selen = houses.length;
        int terlen = heaters.length;

        if(terlen == 1)
            return Math.max(heaters[0] - houses[0], houses[selen - 1] - heaters[0]);

        int res = 0;

        for(int i = 0; i < selen; i++)
        {
            // find the first heater on the right side of i
            int left = 0, right = terlen - 1;
            while (left < right)
            {
                int mid = left + (right - left)/2;
                if(heaters[mid] < houses[i])
                    left = mid + 1;
                else
                    right = mid;
            }

            int l_dist = Integer.MAX_VALUE, r_dist = Math.abs(houses[i] - heaters[right]);
            if(right != 0)
                l_dist = Math.abs(houses[i] - heaters[right - 1]);

            res = Math.max(res, Math.min(l_dist, r_dist));
        }

        return res;
    }
}
