package Hard;

import java.util.Hashtable;

public class LeetCode146_modified {
    private Hashtable<Integer, DLinkedNode> cache = new Hashtable<Integer, DLinkedNode>();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }


    /**
     * 初始化count、capacity
     * 构造dummy head/tail
     *
     * @param capacity
     */
    public LeetCode146_modified(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        tail = new DLinkedNode();

        head.pre = null;
        head.post = tail;

        tail.post = null;
        tail.pre = head;

    }


    private void addNode(DLinkedNode node) {
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    private void removeNode(DLinkedNode node) {//修改一处
        node.pre.post = node.post;
        node.post.pre = node.pre;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    // pop the current tail.(read and delete)
    private DLinkedNode popTail() {
        DLinkedNode tail = this.tail.pre;
        removeNode(tail);
        return tail;
    }


    public int get(int key) {
        if (cache.get(key) != null) {
            DLinkedNode node = cache.get(key);
            moveToHead(node);//使用 移动
            return node.value;
        } else {
            return -1;
        }
    }


    public void wrong_put(int key, int value) { //逻辑错误，以为cache未满才能加
        DLinkedNode node = cache.get(key);
        if (node == null) {
            node = new DLinkedNode();
            node.key = key;
            node.value = value;

            if (count < capacity) {
                count++;
                addNode(node);
                cache.put(key, node);
            } else {
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                count--;
            }

        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    public void put(int key, int value) {//逻辑是add之后满了再删除尾端
        DLinkedNode node = cache.get(key);
        if (node == null) {
            node = new DLinkedNode();
            node.key = key;
            node.value = value;

            count++;
            addNode(node);
            cache.put(key, node);

            if (count > capacity) {
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                count--;
            }

        } else {
            node.value = value;
            moveToHead(node);
        }
    }


}

