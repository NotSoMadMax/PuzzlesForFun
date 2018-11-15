package Hard;

import java.util.*;

// doubly linked list
class DListNode{
    int key;
    int val;
    DListNode prev;
    DListNode next;

    public DListNode(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}


class LRU_Cache {
    protected int cap;
    protected DListNode head;
    protected DListNode tail;
    protected Map<Integer, DListNode> cache;

    public LRU_Cache(int capacity) {
        cap = capacity;
        this.head = new DListNode(-1, -1);
        this.tail = new DListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>();
    }

    public int get(int key) {
        if(!cache.containsKey(key))
            return -1;

        DListNode cur = cache.get(key);
        cur.next.prev = cur.prev;
        cur.prev.next = cur.next;

        move2tail(cur);

        return cur.val;
    }

    public void put(int key, int value) {
        if(get(key) != -1){     // call get instead of cache.get, it will update the new inserted to tail
            cache.get(key).val = value;
            return;
        }

        if(cache.size() == cap){
            cache.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }

        DListNode cur = new DListNode(key, value);
        move2tail(cur);
        cache.put(key, cur);
    }

    // move the recent used nodes to tail
    public void move2tail(DListNode node){
        node.prev = tail.prev;
        tail.prev.next = node;
        node.next = tail;
        tail.prev = node;
    }
}
