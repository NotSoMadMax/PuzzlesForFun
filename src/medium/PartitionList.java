package medium;


public class PartitionList {	
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}	
	
    public static void ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
        	return head;
        
        ListNode first_larger = head;
        
        while(first_larger.val <= x)
        	first_larger = first_larger.next;
        
        
    }
    
    
	public static void main(String[] args) {
		

	}

}
