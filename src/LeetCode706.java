/**
 * 706. Design HashMap
 * Design a HashMap without using any built-in hash table libraries.
 * <p>
 * To be specific, your design should include these functions:
 * <p>
 * put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
 * get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
 * remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
 * <p>
 * Example:
 * <p>
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1);
 * hashMap.put(2, 2);
 * hashMap.get(1);            // returns 1
 * hashMap.get(3);            // returns -1 (not found)
 * hashMap.put(2, 1);          // update the existing value
 * hashMap.get(2);            // returns 1
 * hashMap.remove(2);          // remove the mapping for 2
 * hashMap.get(2);            // returns -1 (not found)
 * <p>
 * Note:
 * <p>
 * All keys and values will be in the range of [0, 1000000].
 * The number of operations will be in the range of [1, 10000].
 * Please do not use the built-in HashMap library.
 */
public class LeetCode706 {

    static class MyHashMap {
        public class ListNode {
            int key, value;
            ListNode next;

            public ListNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        ListNode[] nodes = new ListNode[10000];

        /**
         * Initialize your data structure here.
         */
        public MyHashMap() {
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            int index = idx(key);
            //key not exist->new
            if (nodes[index] == null) {
                nodes[index] = new ListNode(-1, -1);
            }
            ListNode prev = find(nodes[index], key);
            if (prev.next == null) {
                prev.next = new ListNode(key, value);
            }else {
                prev.next.value = value;
            }
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            return 0;
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {

        }

        /**
         * find the previous node of @param node  in nodes
         *
         * @param node
         * @param key
         * @return
         */
        public ListNode find(ListNode node, int key) {
            ListNode tmp = node;
            ListNode pref = null;
            while (tmp != null && tmp.key != key) {
                pref = tmp;
                tmp = tmp.next;
            }
            return pref;
        }

        /**
         * calculate the index of the nodes
         *
         * @param key
         * @return
         */
        public int idx(int key) {
            return key % nodes.length;
        }
    }

    /**
     * Your MyHashMap object will be instantiated and called as such:
     * MyHashMap obj = new MyHashMap();
     * obj.put(key,value);
     * int param_2 = obj.get(key);
     * obj.remove(key);
     */
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        MyHashMap.ListNode listNode = myHashMap.new ListNode(-1, -1);

        listNode.next = myHashMap.new ListNode(1, 10);
        listNode.next.next = myHashMap.new ListNode(2, 20);
        listNode.next.next.next = myHashMap.new ListNode(3,30);
        listNode.next.next.next.next = myHashMap.new ListNode(4,40);
        listNode.next.next.next.next.next = myHashMap.new ListNode(5,50);

        MyHashMap.ListNode node = myHashMap.find(listNode, 3);
    }
}
