package medium;

import java.util.*;

public class MeetingRoomsII {
    private int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length < 1)
            return 0;

        // sort by start time
        Comparator<Interval> IntervalComparator = new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                if(i1.start > i2.start)
                    return 1;
                else if(i1.start < i2.start)
                    return -1;
                else
                    return 0;
            }
        };
        Arrays.sort(intervals, IntervalComparator);

        int res = 1;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(intervals[0].end);
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start < q.peek())
                q.add(intervals[i].end);
            else
            {
                q.poll();
                q.add(intervals[i].end);
            }
            res = Math.max(res, q.size());
        }

        return res;
    }
}
