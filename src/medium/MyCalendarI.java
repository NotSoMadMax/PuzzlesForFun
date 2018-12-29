package medium;

import java.util.*;

class MyCalendarI {
	
	class MyCalendar {
		TreeMap<Integer, Integer> events;	// start time -> end time
		
	    public MyCalendar() {
	        events = new TreeMap<>();
	    }
	    
	    public boolean book(int start, int end) {
	        Integer prev = events.floorKey(start);
	        Integer next = events.ceilingKey(start);
	        
	        if((prev == null || events.get(prev) <= start) && (next == null || end <= next)){
	        	events.put(start, end);
	        	return true;
	        }
	        
	        return false;
	    }
	}
	
}
