package medium;

class ConvertBinarySearchTreetoSortedDoublyLinkedList {
	class Node {
	    public int val;
	    public Node left;
	    public Node right;

	    public Node() {}

	    public Node(int _val,Node _left,Node _right) {
	        val = _val;
	        left = _left;
	        right = _right;
	    }
	};
	
	
	// Method 1: In-Order traversal
	boolean first;
	Node head, prev;
    private Node treeToDoublyList(Node root) {
        if(root == null)
        	return root;
                
        first = true;
        head = new Node();
        prev = new Node();
        search(root);
        
        prev.right = head;
        head.left = prev;
        
        return head;
    }
    
    private void search(Node cur){
    	if(cur == null)
    		return;
    	
    	search(cur.left);
    	
    	if(first)	// reach the left most node
    	{    
    		first = false;
    		head = cur;
    		prev = cur;
    	}else{
    		prev.right = cur;
    		cur.left = prev;
    		prev = cur;
    	}
    	
    	search(cur.right);
    }
    
    
    // Method 2: Divide and Conquer
    private Node treeToDoublyList2(Node root) {
        if(root == null)
        	return root;
        
        Node left = treeToDoublyList2(root.left);
        Node right = treeToDoublyList2(root.right);
        
        root.left = root;
        root.right = root;        
        
        return connect(connect(left, root), right);
    }
    
    // l1 is from left subtree, l2 is from right subtree
    private Node connect(Node l1, Node l2){
    	if(l1 == null)
    		return l2;
    	if(l2 == null)
    		return l1;
    	
    	Node tail1 = l1.left;
    	Node tail2 = l2.left;
    	
    	tail1.right = l2;
    	l2.left = tail1;
    	tail2.right = l1;
    	l1.left = tail2;
    	
    	return l1;
    }
}














