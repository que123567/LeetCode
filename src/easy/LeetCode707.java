package easy;

/**
 *
 */
public class LeetCode707 {
   static class MyLinkedList {
        class Node {
            int val;
            Node next;

            public Node(int val) {
                this.val = val;
            }
        }

        private Node head;
        private int size;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            if (index >= size) {
                return -1;
            }
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.val;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            Node prev = head;
            head = new Node(val);
            head.next = prev;
            size++;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            Node node = new Node(val);
            size++;
            if (head == null) {
                head = node;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = node;
            }
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index == 0) {
                addAtHead(val);
            } else {
                size++;
                Node current = head;
                for (int i = 0; i < index - 1; i++) {
                    current = current.next;
                }
                Node node = new Node(val);
                node.next = current.next;
                current.next = node;
            }
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (index >= size) {
                return;
            }
            size--;
            Node currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            currentNode.next = currentNode.next.next;
        }
    }

    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        System.out.println("---size---");
        System.err.println(myLinkedList.size);
        myLinkedList.addAtHead(3);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(1);
        System.err.println(myLinkedList.size);
        System.err.println(myLinkedList.head.val);

    }
}
