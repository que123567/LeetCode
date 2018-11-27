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
        ListNode[] mNodes = new ListNode[1024];

        /**
         * Initialize your data structure here.
         */
        public MyHashMap() {
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            int index = getIndex(key);
            if (mNodes[index] == null) {
                mNodes[index] = new ListNode(-1, -1);
            }
            ListNode pref = find(mNodes[index], key);
            if (pref.next == null) {
                pref.next = new ListNode(key, value);
            } else {
                pref.next.value = value;
            }
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            int index = getIndex(key);
            if (mNodes[index] == null) {
                return -1;
            }
            ListNode prev = find(mNodes[index], key);
            if (prev == null || prev.next == null) {
                return -1;
            }
            return prev.next.value;
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            int index = getIndex(key);
            if (mNodes[index] == null) {
                return;
            }
            ListNode prev = find(mNodes[index], key);
            if (prev == null || prev.next == null) {
                return;
            }
//            prev.next = null;
            prev.next = prev.next.next;
        }

        private ListNode find(ListNode listNode, int key) {
            ListNode temp = listNode;
            ListNode prev = null;
            while (temp != null && temp.key != key) {
                prev = temp;
                temp = temp.next;
            }
            return prev;
        }

        private int getIndex(int key) {
            return key < 0 ? 0 : key % mNodes.length;
        }

        public class ListNode {
            private int key, value;
            ListNode next;

            public ListNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        for (int i = 0; i < 20; i++) {
            myHashMap.put(i % 10, i % 10);
        }
        System.out.println(myHashMap.get(2));
        System.out.println(myHashMap.get(3));
        System.out.println(myHashMap.get(0));
        System.out.println(myHashMap.get(-1));
    }
}
