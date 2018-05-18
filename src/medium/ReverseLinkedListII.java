package medium;

public class ReverseLinkedListII {
	
    private static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m < 0 || n < 0 || m >= n)
        		return head;
        
        ListNode temp = new ListNode(-1);
        temp.next = head;
        
        ListNode node_m = temp;
        ListNode right = temp, left = temp;
        
        for(int i = 0; i < m - 1; i++){	// find the node before m
        		node_m = node_m.next;
        }
        
        if (node_m.next != null){
        		left = node_m.next; // node m
        		right = left.next;
        }        		
        else
        		return temp.next;
        
        for (int i = m; i < n; i++){
        		left.next = right.next;
        		right.next = node_m.next;
        		node_m.next = right;
        		
        		right = left.next;
        }
        	
        return temp.next;
    }
    
	public static void main(String[] args) {


	}

}
