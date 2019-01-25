package medium;

import DataStructure.ListNode;

/**
 * 24. Swap Nodes in Pairs
 * .
 * Given a linked list, swap every two adjacent nodes and return its head.
 * .
 * Example:
 * .
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Note:
 * .
 * Your algorithm should use only constant extra space.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 */
public class LeetCode24 {
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next, second = cur.next.next;

            first.next = second.next;
            cur.next = second;
            cur.next.next = first;
            cur = cur.next.next;
        }
        return dummy.next;
    }

    /**
     *  XXXXXXXXXXX
     * 递归版本
     * @return
     */
    public static ListNode swapPairs_R(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }

    public static void main(String[] args) {
        ListNode node1 = ListNode.makeListNodeTestCase4();
        var res1 = swapPairs(node1);
        int i = 1;

    }
}
