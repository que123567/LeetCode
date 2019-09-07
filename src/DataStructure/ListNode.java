package DataStructure;

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
        node.next.next = new ListNode(1);
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
    public static ListNode makeListNodeTestCase6() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(1);
        return node;
    }
}
