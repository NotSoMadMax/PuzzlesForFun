package Easy;

import java.util.*;

class LinkedListCycle {
	// Method 1: Set
    private boolean hasCycle1(ListNode head) {
        if(head == null)
        	return false;
        
        Set<ListNode> s = new HashSet<>();
        while(head != null){
        	if(!s.contains(head))
        		s.add(head);
        	else
        		return true;
        	
        	head = head.next;
        }
        
        return false;
    }
    
    // Method 2: Two Pointers
    private boolean hasCycle2(ListNode head) {
        if(head == null)
        	return false;
        
        ListNode slow = head, fast = head.next;
        while(fast != null){
        	if(slow == fast)
        		return true;
        	slow = slow.next;
        	fast = fast.next;
        	if(fast != null)
        		fast = fast.next;
        }        
        return false;
    }
}
