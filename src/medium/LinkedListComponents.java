package medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class LinkedListComponents {
    private int numComponents(ListNode head, int[] G) {
        if(head == null)
        	return 0;
        
        Set<Integer> s = new HashSet<Integer>();
        for(int i:G)
        	s.add(i);
        
        int res = 0;
        while(head.next != null){        	
            if(s.contains(head.val) && !s.contains(head.next.val))
            	res++;        		
            head = head.next;
        }
        
        if(s.contains(head.val))
        	res++;
        
        return res;
    }
}
