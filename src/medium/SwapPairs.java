package medium;

import org.omg.CORBA.PUBLIC_MEMBER;

import medium.RemoveNthNodeFromEndofList.ListNode;

public class SwapPairs {
	
	static private class ListNode{
		int val;
		ListNode next;
		ListNode(int x) {val = x;}				
	}
	
	static private ListNode swap(ListNode head){
		if (head == null || head.next == null)
			return head;
		if (head.next.next == null){
			ListNode temp = head.next;
			temp.next = head;
			head.next = null;
			return temp;
		}
		
		ListNode result = head.next;
		inverse(head);
		
		return result;
	}
	
	static private void inverse(ListNode cur){				
		if (cur.next.next == null){ // last pair
			cur.next.next = cur;
			cur.next = null;
			return;
		}
		
		ListNode newhead = cur.next.next;
		cur.next.next = cur;
		
		if (newhead.next == null){    // 1-2-3			
			cur.next = newhead;
			return;
		}
		
		cur.next = newhead.next;
		inverse(newhead);		
	}
	
	public static void main(String args[]){
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);

		a.next = b;
		b.next = c;
		c.next = d;
		d.next = null;
		
		ListNode cur = a;
		while (cur != null){
			System.out.print(cur.val + "->");
			cur = cur.next;
		}
		System.out.print("\n\n");
		
		cur = swap(a);
		while (cur != null){
			System.out.print(cur.val + "->");
			cur = cur.next;
		}
	}
}





