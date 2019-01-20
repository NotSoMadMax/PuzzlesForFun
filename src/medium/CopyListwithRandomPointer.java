package medium;

import java.util.*;

class CopyListwithRandomPointer {
	
	class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	};
	
	// Method 1: O(n) Space
    private RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
        	return head;
        
        Map<RandomListNode, RandomListNode> m = new HashMap<>();	// old node -> new node
        RandomListNode nhead = new RandomListNode(head.label);
        m.put(head, nhead);
        
        RandomListNode old_cur = head;
        RandomListNode new_cur = nhead;
    	while(old_cur != null){
    		if(old_cur.next != null)
    		{
        		if(m.containsKey(old_cur.next))
        			new_cur.next = m.get(old_cur.next);
        		else{
        			RandomListNode temp = new RandomListNode(old_cur.next.label);
        			new_cur.next = temp;
        			m.put(old_cur.next, temp);
        		}
    		}
    		
    		if(old_cur.random != null)
    		{
        		if(m.containsKey(old_cur.random))
        			new_cur.random = m.get(old_cur.random);
        		else{
        			RandomListNode temp = new RandomListNode(old_cur.random.label);
        			new_cur.random = temp;
        			m.put(old_cur.random, temp);
        		}
    		}
    		
    		old_cur = old_cur.next;
    		new_cur = new_cur.next;
    	}
    	
    	return nhead;
    }
    
    // Method 2: O(1) Space
    private RandomListNode copyRandomList2(RandomListNode head) {
        if(head == null)
        	return head;                
        
        RandomListNode ocur = head;        
        
        // First iteration: create new node using only next
        while(ocur != null){    	
        	RandomListNode n_next = new RandomListNode(ocur.label);
        	n_next.next = ocur.next;
        	ocur.next = n_next;
        	
        	ocur = n_next.next;        	      	
        }
        
        // Second iteration: set the random pointer
        ocur = head;
        while(ocur != null){
        	if(ocur.random != null)
        		ocur.next.random = ocur.random.next;
        	ocur = ocur.next.next;
        }
        
        // Third iteration: reset the next pointer
        ocur = head;
        RandomListNode ncur = head.next;
        
        RandomListNode nhead = head.next;
        while(ncur != null){
        	ocur.next = ncur.next;
        	ocur = ncur.next;
        	
        	if(ocur == null)	// when reach the last pair
        		break;
        	
        	ncur.next = ocur.next;
        	ncur = ncur.next;
        }
        
        return nhead;
    }
}















