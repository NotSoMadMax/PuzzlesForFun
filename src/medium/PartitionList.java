package medium;
import medium.RemoveNthNodeFromEndofList.ListNode;


public class PartitionList {	
		
    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
        	return head;
        
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode cur = helper, holder = helper;
        
        while(cur.next != null) {
        	if (cur.next.val < x) {
        		if(cur != holder) {
        			ListNode temp = cur.next.next;
        			cur.next.next = holder.next;
        			holder.next = cur.next;
        			cur.next = temp;
        		} else {
        			cur = cur.next;
        		}
        		holder = holder.next;
        	} else {
        		cur = cur.next;
        	}
        }
        
                
        return helper.next;
    }
    
    
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		
	}

}
