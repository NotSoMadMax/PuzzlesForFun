package Easy;

public class ReverseLinkedList {
    // method 1: recursion
    private static ListNode recursiveReverse(ListNode head){
        if(head == null || head.next == null)
            return head;

        ListNode p = head;
        head = recursiveReverse(p.next);
        p.next.next = p;
        p.next = null;

        return head;
    }

    // method 2: iteration
    private static ListNode iterReverse(ListNode head){
        if(head == null || head.next == null)
            return head;

        ListNode cur = head;
        ListNode pre = null;

        while (cur != null){
            ListNode nex = cur.next;

            cur.next = pre;
            pre = cur;
            cur = nex;
        }

        return pre;
    }

}
