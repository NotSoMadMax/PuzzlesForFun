package medium;

public class SortList {
	// Method 1: merge sort
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
        	return head;
        
        // Break into half
        ListNode first = head;
        ListNode second = head;      
        ListNode breakPoint = first;       
        while(second != null && second.next != null) {
        	breakPoint = first;
        	first = first.next;
        	second = second.next.next;
        }
        breakPoint.next = null;
        
        // Sort sublists
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(first);
        
        // compare and merge
        return merge(l1, l2);
    }
    
    private ListNode merge(ListNode n1, ListNode n2) {
    	if(n1 == null || n2 == null)
    		return n1 == null? n2 : n1;
    	
    	if(n1.val < n2.val){
    		n1.next = merge(n1.next, n2);
    		return n1;
    	} else {
    		n2.next = merge(n1, n2.next);
    		return n2;
    	}    		    	    	
    }
    
	// Method 2: quick sort
	public ListNode sortList2(ListNode head) {
        if(head == null || head.next == null)
        	return head;
        
        return quickSort(head);
	}
	
	private ListNode quickSort(ListNode head) {
		ListNode smallerHead = new ListNode(0);
		ListNode biggerHead = new ListNode(0);
		
		ListNode smallerCur = smallerHead;
		ListNode biggerCur = biggerHead;		
		ListNode equalCur = head;
		ListNode cur = head.next;		
		while (cur != null) {
			if (cur.val < head.val) {
				smallerCur.next = cur;
				smallerCur = smallerCur.next;
			} else if (cur.val > head.val) {
				biggerCur.next = cur;
				biggerCur = biggerCur.next;
			} else {
				equalCur.next = cur;
				equalCur = equalCur.next;
			}
			cur = cur.next;
		}
		
		smallerCur.next = null;
		biggerCur.next = null;
		equalCur.next = null;
		
		smallerHead.next = quickSort(smallerHead.next);
		biggerHead.next = quickSort(biggerHead.next);
		
		cur = smallerHead;
		while(cur.next != null) {
			cur = cur.next;
		}
		
		cur.next = head;
		equalCur.next = biggerHead.next;
		
		return smallerHead.next;
	}
	
}
