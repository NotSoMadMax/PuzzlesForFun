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
                lists[begin] = merge(lists[begin], lists[end]);
                begin++;
                end--;
            }
        }

        return lists[0];
    }


    // merge two list
    private static ListNode merge(ListNode h1, ListNode h2){
        if(h1 == null && h2 == null)
            return null;
        if(h1 == null)
            return h2;
        if(h2 == null)
            return h1;

        ListNode cur1 = h1, cur2 = h2;
        ListNode head;  // to return
        if(cur1.val <= cur2.val){
            head = new ListNode(cur1.val);
            cur1 = cur1.next;
        }else {
            head = new ListNode(cur2.val);
            cur2 = cur2.next;
        }

        ListNode cur = head;
        while (cur1 != null && cur2 != null){
            if(cur1.val <= cur2.val){
                cur.next = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur2 = cur2.next;
            }

            cur = cur.next;
        }

        if(cur1 == null)
            cur.next = cur2;
        else
            cur.next = cur1;

        return head;
    }


    /* // priority queue, 82.33%
    private ListNode mergeKLists(ListNode[] lists){
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
    */

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
