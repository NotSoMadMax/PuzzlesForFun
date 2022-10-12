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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }
        
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode cur = head;
        while(cur != null) {
            stack.addFirst(cur);
            cur = cur.next;
        }
        
        int toRemove = (stack.size() - 1)/2;
        cur = head;
        while(toRemove > 0) {
            ListNode node = stack.removeFirst();
            ListNode next = cur.next;
            cur.next = node;
            node.next = next;
            cur = next;
            toRemove--;
        }
        stack.peekFirst().next = null;
        
        return;
    }
}