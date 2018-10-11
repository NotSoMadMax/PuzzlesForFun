package Easy;

 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;

        ListNode fast = head;
        ListNode slow = head;

        // find middle point
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second half
        ListNode pre = slow, cur = slow.next, nex = null;
        while (cur != null){
            nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }

        ListNode cur1 = head, cur2 = pre;
        while (cur1 != cur2){
            if(cur1.val != cur2.val)
                return false;
            else {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }

            if(cur1.next == cur2){
                return cur1.val == cur2.val?true:false;
            }
        }

        return true;
    }
}
