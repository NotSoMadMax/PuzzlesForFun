package medium;

import medium.RemoveNthNodeFromEndofList.ListNode;

public class RemoveDuplicatesfromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
        	return head;

        ListNode temp = new ListNode(-1);   // help changing head
        temp.next = head;
        ListNode cur = head, pre = temp;

        while(cur.next != null){
            while(cur.next != null && cur.next.val == pre.next.val)
                cur = cur.next;

            if (pre.next == cur){
                pre = pre.next
            } else {
                pre.next = cur.next;
            }

        }

        return temp.next;
    }

	public static void main(String[] args) {

	}

}
