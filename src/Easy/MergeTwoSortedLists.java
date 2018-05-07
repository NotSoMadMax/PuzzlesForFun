package Easy;

public class MergeTwoSortedLists {
	private class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 }
	
	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if (l1 == null && l2 == null)
    		return null;
    	
    	if (l1 == null)
    		return l2;
    	else if (l2 == null)
    		return l1;
    	else if (l1.val < l2.val){
    		l1.next = mergeTwoLists(l1.next, l2);
    		return l1;
    	} else {
    		l2.next = mergeTwoLists(l2.next, l1);
    		return l2;
    	}
    }
}
