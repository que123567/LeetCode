package hard;

import java.util.HashMap;
import java.util.Map;

public class LruCache {

    private DLinkedNode head, tail;
    private int count, capacity;
    private Map<Integer, DLinkedNode> cache = new HashMap<>();


    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;
    }

    public LruCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;

        head = new DLinkedNode();
        tail = new DLinkedNode();

        head.next = tail;
        head.pre = null;

        tail.pre = head;
        tail.next = null;
    }

    /**
     * get key
     *
     * @param key
     * @return
     */
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        removeAndSetHead(node);
        return node.value;
    }


    /**
     * put key vaule
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            //new
            node = new DLinkedNode();
            node.key = key;
            node.value = value;
            //put
            cache.put(key, node);
            setAfterHead(node);
            count++;
            //check capacity
            if (count > capacity) {
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                count--;
            }
        } else {
            //override value
            node.value = value;
            //adjust order
            removeAndSetHead(node);
        }
    }


    public DLinkedNode popTail() {
        DLinkedNode res = tail.pre;
        removeNode(tail.pre);
        return res;
    }


    public void removeAndSetHead(DLinkedNode node) {
        removeNode(node);
        setAfterHead(node);
    }

    public void setAfterHead(DLinkedNode node) {
        node.pre = head;
        node.next = head.next;

        head.next.pre = node;
        head.next = node;
    }

    public void removeNode(DLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }


    public static void main(String[] args) {
//        LruCache cache = new LruCache(2);
//        cache.put(1, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(1));
//        cache.put(3, 3);    // evicts key 2
//        System.out.println(cache.get(2));
//        cache.put(4, 4);    // evicts key 1
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(3));
//        System.out.println(cache.get(4));

        for (int j = 0; j < 10; j++) {
            int i = j;
            System.out.println((i += 1) % 4);
        }
    }
}
