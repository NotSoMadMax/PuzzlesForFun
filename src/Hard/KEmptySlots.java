package Hard;

import java.util.*;

public class KEmptySlots {

    // Method 2: sliding window, 55%
    private int kEmptySlots2(int[] flowers, int k) {
        if(flowers == null || flowers.length < k + 2)
            return -1;

        int[] days = new int[flowers.length];   // day of blooming for position i
        for(int i = 0; i < flowers.length; i++){
            days[flowers[i] - 1] = i + 1;
        }

        int res = Integer.MAX_VALUE;

        int left = 0, right = k + 1;
        while (right < flowers.length)
        {
            boolean flag = true;
            for(int i = left + 1; i < right; i++)
            {
                if(days[i] < days[left] || days[i] < days[right]){  // this window is invalid
                    left = i;
                    right = i + k + 1;
                    flag = false;
                    break;
                }
            }

            if(flag)
            {   // this is a valid window
                res = Math.min(res, Math.max(days[left], days[right]));
                left = right;
                right = left + k + 1;
            }
        }

        return res==Integer.MAX_VALUE?-1:res;
    }


    //Method 1: Sorted set, 28%
    private int kEmptySlots(int[] flowers, int k) {
        if(flowers == null || flowers.length < k + 2)
            return -1;

        TreeSet<Integer> s = new TreeSet<>();
        s.add(flowers[0]);
        for(int i = 1; i < flowers.length; i++){
            Integer pre = s.lower(flowers[i]);  // closest blooming position on the left
            Integer next = s.higher(flowers[i]);    // closest blooming position on the right

            if(pre != null){
                if(flowers[i] - pre.intValue() - 1 == k)
                    return i + 1;
            }
            if(next != null){
                if(next.intValue() - flowers[i] - 1 == k)
                    return i + 1;
            }

            s.add(flowers[i]);
        }

        return -1;
    }
}
