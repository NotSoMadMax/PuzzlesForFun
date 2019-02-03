package Hard;

import java.util.*;

 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }

class NodeComparator implements Comparator<ListNode>{
    public int compare(ListNode a, ListNode b) {
        if (a.val < b.val)
            return -1;
        else if (a.val > b.val)
            return 1;
        return 0;
    }
}

public class MergeKSortedList {

     // merge sort, 88.78%
    private ListNode mergeKLists(ListNode[] lists){
        if(lists == null || lists.length < 1)
            return null;

        int begin = 0;
        int end = lists.length - 1;
        while (end > 0){
            begin = 0;
            while (begin < end){
                lists[begin] = mergeTwoLists(lists[begin], lists[end]);
                begin++;
                end--;
            }
        }

        return lists[0];
    }

	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if (l1 == null)
    		return l2;
    	
    	if (l2 == null)
    		return l1;

    	if (l1.val < l2.val){
    		l1.next = mergeTwoLists(l1.next, l2);
    		return l1;
    	} else {
    		l2.next = mergeTwoLists(l2.next, l1);
    		return l2;
    	}
    }    


    // Method 2: priority queue, 82.33%
    private ListNode mergeKLists1(ListNode[] lists){
        if(lists == null || lists.length < 1)
            return null;

        int len = lists.length;
        PriorityQueue<ListNode> heap = new PriorityQueue<>(len, new NodeComparator());
        for(int i = 0; i < len; i++){
            if(lists[i] != null)
                heap.add(lists[i]);
        }
        if(heap.isEmpty())
            return null;

        ListNode temp = heap.poll();
        ListNode head = new ListNode(temp.val);
        if(temp.next != null)
            heap.add(temp.next);
        ListNode cur = head;

        while (!heap.isEmpty()){
            ListNode small = heap.poll();
            cur.next = new ListNode(small.val);
            cur = cur.next;

            small = small.next;
            if(small != null)
                heap.add(small);
        }

        return head;
    }
    

    /* // insert all node to heap, exceed space limit
     private ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length < 1)
            return null;

        int len = lists.length;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(ListNode cur:lists){
            while (cur != null){
                heap.add(cur.val);
            }
        }

        if(heap.size() < 1)
            return null;

        ListNode head = new ListNode(heap.poll());
        ListNode cur = head;
        while (!heap.isEmpty()){
            cur.next = new ListNode(heap.poll());
        }

        return head;
    }
    */
}
