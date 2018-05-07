package medium;

class ListNode{
	 int val;
	 ListNode next;
	 ListNode(int x) { val = x; }	
}

public class RotateList {
	private ListNode rotateRight(ListNode head, int k){
		if (k <= 0 || head == null)
				return head;
		
		int n = 1;				
		ListNode cur = new ListNode(-1);
		cur = head;
		while (cur.next != null){
			cur = cur.next;
			n++;			
		}
		
		if (n == 1 || k == n)
			return head;
		
		cur.next = head;
		for (int i = 0; i < n - k % n; i++)
			cur = cur.next;					

		ListNode ans = cur.next;
		cur.next = null;				
		return ans;
	}
	
	
}


