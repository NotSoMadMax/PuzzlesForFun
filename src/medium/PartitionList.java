package medium;
import medium.RemoveNthNodeFromEndofList.ListNode;


public class PartitionList {	

	// Method 1
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

    
	// Method 2
	public static ListNode partition2(ListNode head, int x) {
		if (head == null || head.next == null)
			return head;

		ListNode small_head = new ListNode(0);
		ListNode large_head = new ListNode(0);
		ListNode cur_small = small_head, cur_large = large_head;

		ListNode cur = head;

		while (cur != null){
			if(cur.val < x){
				cur_small.next = cur;
				cur_small = cur_small.next;
			} else {
				cur_large.next = cur;
				cur_large = cur_large.next;
			}

			cur = cur.next;
		}

		cur_small.next = large_head.next;
		cur_large.next = null;	// without this line: memory limit exceeded

		return small_head.next;
	}

}
