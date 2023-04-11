package DataStructure;

import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }


    public static ListNode makeListNodeTestCase1() {
        ListNode node = new ListNode(1);
        return node;
    }

    public static ListNode makeListNodeTestCase2() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        return node;
    }

    public static ListNode makeListNodeTestCase3() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(3);
        node.next.next = new ListNode(5);
        return node;
    }

    public static ListNode makeListNodeTestCase4() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        return node;
    }

    public static ListNode makeListNodeTestCase5() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        return node;
    }

    public static ListNode makeListNodeTestN(int n) {
        ListNode node = new ListNode(0);
        ListNode head = node;
        for (int i = 1; i < n; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        return head;
    }

    public static ListNode makeListNodeTestN(int n, List<Integer> list) {
        if (list.size() != n) {
            return null;
        }
        ListNode node = new ListNode(list.get(0));
        ListNode head = node;
        for (int i = 1; i < n; i++) {
            node.next = new ListNode(list.get(i));
            node = node.next;
        }
        return head;
    }

    public static ListNode makeListNodeTestCase6() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(1);
        return node;
    }
}
