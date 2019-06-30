package Easy;

class IntersectionofTwoLinkedLists {
	
	// Method 1: find length first, 97.51% speed, 55.16% memory
    private ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
        	return null;
        
        int len1 = 0, len2 = 0;
        for(ListNode cur = headA; cur != null; cur = cur.next)
        	len1++;
        for(ListNode cur = headB; cur != null; cur = cur.next)
        	len2++;
        	
    	ListNode cur1 = headA, cur2 = headB;
    	if(len1 > len2){
    		for(int i = 0; i < len1 - len2; i++)
    			cur1 = cur1.next;
    	}else{
    		for(int i = 0; i < len2 - len1; i++)
    			cur2 = cur2.next;
    	}
    		
    	while(cur1.next != null){
    		if(cur1 == cur2)
    			break;
    		cur1 = cur1.next;
    		cur2 = cur2.next;
    	}    	
    	
    	if(cur1 == cur2)
    		return cur1;
    	else
    		return null;
    }
    
    
    //Method 2: equal travel lengths, 97.51% speed, 51.75% memory
    private ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
        	return null;
        
        ListNode cur1 = headA, cur2 = headB;
        
        while(cur1 != cur2){
        	if(cur1 == null)
        		cur1 = headB;
        	else
        		cur1 = cur1.next;
        	
        	if(cur2 == null)
        		cur2 = headA;
        	else
        		cur2 = cur2.next;
        }        
        
        return cur1;
    }
    
}


