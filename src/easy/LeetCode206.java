package easy;

import DataStructure.ListNode;
import DataStructure.Utils;

/**
 * 206. Reverse Linked List
 * <p>
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 * <p>
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class LeetCode206 {
    /**
     * Iteration
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }


    /**
     * recursive solution
     *
     * @param head
     * @return
     */
    public static ListNode reverseList_(ListNode head) {
        return reverseListInt_(head, null);
    }

    private static ListNode reverseListInt_(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt_(next, head);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(3);
        reverseList_(l1.next.next.next.next);

        Utils.getInstance().TraverListNode(l1);
    }
}
