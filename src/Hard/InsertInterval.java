package Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
}

class mycomarator implements Comparator<Interval>
{

    public int compare(Interval a, Interval b)
    {	    		
    		if (a.start > b.start)
    			return 1;
    		else if (a.start < b.start)
    			return -1;
    		else
    			return 0;
    }
}


public class InsertInterval {
    private static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int len = intervals.size();
        if (newInterval == null)
        		return intervals;
        if (len < 1 || intervals == null){
        		intervals.add(newInterval);
        		return intervals;
        }
        		
        
        intervals.add(newInterval);
        Collections.sort(intervals, new mycomarator());
        
        List<Interval> res = new ArrayList<>();
        res.add(intervals.get(0));
        for (int i = 1; i < len + 1; i++){
        		Interval cur = intervals.get(i);        		
        		if (cur.start <= res.get(res.size() - 1).end){
        			if (cur.end <= res.get(res.size() - 1).end)
            			continue;
        			else
        				res.get(res.size() - 1).end = cur.end;
        		} else {
				res.add(cur)	;
			}
        }

        return res;
    }
    
    public static void main(String[] args){

    }
}


