package easy;

import DataStructure.ListNode;

/**
 * 21. Merge Two Sorted Lists
 * .
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * .
 * Example:
 * .
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class LeetCode21 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode cur = new ListNode(0), dummyHead = cur;
        while (l1 != null & l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return dummyHead.next;
    }

    /**
     * recursion
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists_(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
        }
        return l1.val < l2.val ? l1 : l2;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(5);

        ListNode l3 = mergeTwoLists_(l1, l2);
        while (l3 != null) {
            System.out.print(l3.val + " ");
            l3 = l3.next;
        }
    }
}
