package medium;

class InsertintoaCyclicSortedList {

    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val,Node _next) {
            val = _val;
            next = _next;
        }
    }

    private Node insert(Node head, int insertVal) {
        if(head == null){
        	head = new Node(insertVal, null);        	
        	head.next = head;
        	return head;
        }
        
        Node prev = head;
        Node cur = prev.next;        
        
        while(cur != head){
        	if(prev.val <= insertVal && insertVal <= cur.val)
        		break;
        	if((prev.val > cur.val) && (insertVal >= prev.val || insertVal <= cur.val))
        		break;
        	
        	cur = cur.next;
        	prev = prev.next;
        }
        
        Node temp = new Node(insertVal, cur);
        prev.next = temp;
        
        return head;
    }
}










