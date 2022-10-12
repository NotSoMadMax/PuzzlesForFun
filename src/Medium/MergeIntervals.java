package medium;

import java.util.ArrayList;
import java.util.Arrays;
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

public class MergeIntervals {
    public static List<Interval> merge(List<Interval> intervals) {
        int len = intervals.size();
        if (len < 1 || intervals == null)	return Collections.emptyList();
        
        List<Interval> result = new ArrayList<>();
        Collections.sort(intervals, new mycomarator());
        
        result.add(intervals.get(0));
        for (Interval i:intervals){
        		if (i.start > result.get(result.size() - 1).end)
        			result.add(i);
        		else if (i.start <= result.get(result.size() - 1).end && i.end > result.get(result.size() - 1).end){
        			Interval pre = result.remove(result.size() - 1);
        			result.add(new Interval(pre.start, i.end));
        		} else {
				continue;
			}     		
        }
        
        return result;
    }
    
    
	public static void main(String[] args) {
		List<Interval> test = new ArrayList<>();
		for (int i = 5; i > 0; i--){
			Interval a = new Interval(i, i + 3);
			test.add(a);
		}
		
		for(Interval i:test){
			System.out.print(i.start + "," + i.end + "->");
		}
		
		List<Interval> ans = merge(test);
		
		System.out.println("\n");
		for(Interval i:ans){
			System.out.print(i.start + "," + i.end + "->");
		}
		
		return;
	}

}
