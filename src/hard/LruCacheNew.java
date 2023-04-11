package hard;

import java.util.HashMap;
import java.util.Map;

public class LruCacheNew<K, V> {
    private int capacity;
    private Map<K, LruNode> mKLruNodeMap;
    private LruNode head;
    private LruNode tail;

    public LruCacheNew(int capacity) {
        this.capacity = capacity;
        mKLruNodeMap = new HashMap<>(capacity);
    }

    class LruNode<K, V> {
        private K Key;
        private V Value;
        private LruNode prev;
        private LruNode next;

        public LruNode(K key, V value) {
            Key = key;
            this.Value = value;
        }
    }

    private void setHead(LruNode node) {
        if (head == null) {
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
        }
        head = node;
    }

    private void put(K k, V v) {
        LruNode node = mKLruNodeMap.get(k);
        //不存在
        if (node == null) {
            node = new LruNode(k, v);
            mKLruNodeMap.put(k, node);
            setHead(node);
            if (mKLruNodeMap.size() > capacity) {
                remove(tail, true);
            }
        } else {
            remove(node, false);
            setHead(node);
        }
    }

    private Object get(K k) {
        LruNode node = mKLruNodeMap.get(k);
        if (node != null) {
            remove(node, false);
            setHead(node);
            return node.Value;
        }
        return null;
    }

    private void remove(LruNode<K, V> node, boolean flag) {
        if (node.prev == null) {
            head = node.next;
        } else {
            node.prev.next = node.next;
        }

        if (node.next == null) {
            tail = node.prev;
        } else {
            node.next.prev = node.prev;
        }

        node.prev = null;
        node.next = null;
        if (flag) {
            mKLruNodeMap.remove(node.Key);
        }
    }

    public static void main(String[] args) {
        LruCacheNew<String, String> lruCache = new LruCacheNew<String, String>(5);

        lruCache.put("1", "a");
        lruCache.put("2", "b");
        lruCache.put("3", "c");
        lruCache.put("4", "d");
        lruCache.put("5", "e");

        System.out.println("插入 5 个元素");
        println(lruCache);

        System.out.println("插入 3 元素");
        lruCache.put("3", "c");
        println(lruCache);

        System.out.println("插入第  6 个元素");
        lruCache.put("6", "f");
        println(lruCache);

        System.out.println("访问 4 元素");
        lruCache.get("4");
        println(lruCache);
    }

    private static void println(LruCacheNew lruCache) {
        LruCacheNew.LruNode node = lruCache.head;
        while (node != null) {
            System.out.print(node.Key + "    ");
            node = node.next;
        }

        System.out.println();
    }

}
