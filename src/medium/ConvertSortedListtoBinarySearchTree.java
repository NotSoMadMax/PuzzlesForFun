package medium;

class ConvertSortedListtoBinarySearchTree {
    private TreeNode sortedListToBST(ListNode head) {
        if (head == null)
        	return null;
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre_slow = null;
        
        while(fast != null && fast.next != null){
        	pre_slow = slow;
        	slow = slow.next;
        	fast = fast.next.next;
        }
        
        TreeNode root = new TreeNode(slow.val);
        
        if (pre_slow == null){
        	head = null;
        } else {
        	pre_slow.next = null;
        }
        
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
