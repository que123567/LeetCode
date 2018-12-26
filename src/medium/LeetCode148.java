package medium;

import DataStructure.ListNode;

/**
 * 148. Sort List
 * .
 * Sort a linked list in O(n log n) time using constant space complexity.
 * .
 * Example 1:
 * .
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * Example 2:
 * .
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
public class LeetCode148 {
    /**
     * merge sort
     *
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {
        //check not null
        if (head == null || head.next == null) {
            return head;
        }
        //cut the list into two halves
        ListNode pre = null, walker = head, runner = head;
        while (runner != null && runner.next != null) {
            pre = walker;
            walker = walker.next;
            runner = runner.next.next;
        }
        pre.next = null;
        //sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(walker);

        //merge two halves
        return merge(l1, l2);
    }

    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode list = new ListNode(0);
        ListNode res = list;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                list.next = l1;
                l1 = l1.next;
            } else {
                list.next = l2;
                l2 = l2.next;
            }
            list = list.next;
        }
        if (l1 != null) {
            list.next = l1;
        }
        if (l2 != null) {
            list.next = l2;
        }
        return res.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(6);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(5);


        l1.next.next.next.next = l2;
        sortList(l1);
        while (l1 != null) {
            System.out.print(l1.val + " ");
            l1 = l1.next;
        }
    }
}
