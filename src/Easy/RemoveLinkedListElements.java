/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return head;
        }
        
        while(head != null && head.val == val) {
            head = head.next;
        }
        
        ListNode prev = new ListNode();
        ListNode cur = head;
        prev.next = cur;
        while(cur != null) {
            if(cur.val == val) {
                cur = removeNode(prev, cur);
            }
            prev = cur;
            cur = cur.next;
        }
        
        return head;
    }
    
    private ListNode removeNode(ListNode prev, ListNode toRemove) {
        if (toRemove.next == null) {
            prev.next = null;
            return prev;
        }
        
        prev.next = toRemove.next;
        toRemove.next = null;
        return prev;
    }
}