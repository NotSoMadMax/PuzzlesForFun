package medium;

public class RemoveNthNodeFromEndofList {
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	private static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode result = new ListNode(-1);
		result.next = head;
		
		ListNode first = result;
		ListNode second = result;
		
		for (int i = 0; i <= n; i++)
			first = first.next;
		
		while(first != null){
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		
		return result.next;
    }
	
	public static void main(String args[]){
		
		ListNode a = new ListNode(0);
		ListNode b = new ListNode(1);
		ListNode c = new ListNode(2);
		ListNode d = new ListNode(3);

		a.next = b;
		b.next = c;
		c.next = d;
		d.next = null;

		ListNode cur = a;
		while(cur != null){
			System.out.print(cur.val + "-");
			cur = cur.next;
		}
		
		int n = 4;
		System.out.println("\n\nn = " + n);
		cur = removeNthFromEnd(a, n);
		while(cur != null){
			System.out.print(cur.val + "-");
			cur = cur.next;
		}	
		return;
	}
}








