package medium;

import java.util.*;

class MyCalendarII {
	
	class MyCalendarTwo {
		TreeMap<Integer, Integer> events;
		
	    public MyCalendarTwo() {
	        events = new TreeMap<>();
	    }
	    
	    public boolean book(int start, int end) {
	        events.put(start, events.getOrDefault(start, 0) + 1);
	        events.put(end, events.getOrDefault(end, 0) - 1);
	        
	        int cur_n_events = 0;
	        for(int ts:events.values()){
	        	cur_n_events += ts;
	        	
	        	if(cur_n_events == 3){
	        		events.put(start, events.get(start) - 1);
	        		events.put(end, events.get(end) + 1);
	        		
	        		if(events.get(start) == 0)
	        			events.remove(start);
	        		if(events.get(end) == 0)
	        			events.remove(end);
	        		
	        		return false;
	        	}
	        }
	        
	        return true;
	    }
	}
	
}
