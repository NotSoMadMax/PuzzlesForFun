package medium;

class SplitLinkedListinParts {
    private ListNode[] splitListToParts(ListNode root, int k) {
    	ListNode[] res = new ListNode[k];
    	
    	if(root == null){
        	return res;
        }
    	
    	int size = 0;
    	ListNode cur = root;
    	while(cur != null){
    		size++;
    		cur = cur.next;
    	}
    	
    	int[] ss = new int[k];
    	int remain = size % k;
    	for(int i = 0; i < k; i++){
    		ss[i] = size/k;
    		if(remain != 0){
    			ss[i]++;
    			remain--;
    		}    			
    	}
    		
    	int part = 0;
    	cur = root;
    	ListNode prev = new ListNode(-1);
    	prev.next = cur;
    	
    	while(cur != null){
    		int cur_part = ss[part];
    		res[part] = cur;
    		prev.next = null;
    		
    		prev = cur;
    		cur = cur.next;
    		cur_part--;
    		while(cur != null && cur_part != 0){    			
    			cur = cur.next;
    			prev = prev.next;
    			cur_part--;
    		}
    		    		
    		part++;
    	}
    	    	
    	return res;
    }
}
