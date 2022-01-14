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

    /**
     * recursion
     */
    public static ListNode mergeTwoLists_2(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists_2(l1.next, l2);
        } else {
            l2.next = mergeTwoLists_2(l2.next, l1);
        }
        return l1.val < l2.val ? l1 : l2;
    }

    public static ListNode mergeTwoLists_3(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists_3(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists_3(l1, l2.next);
            return l2;
        }
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return null;
    }

    /**
     * * @param l1 链表1
     * * @param l2 链表2
     * * @return 合并的有序链表
     */
    public static ListNode mergeTwoList2(ListNode L1, ListNode L2) {
        //check null
        if (L1 == null || L2 == null) {
            return L1 == null ? L2 : L1;
        }
        ListNode resortListNode = new ListNode(0);
        ListNode dummyHead = resortListNode;

        while (L1 != null && L2 != null) {
            if (L1.val < L2.val) {
                resortListNode.next = L1;
                L1 = L1.next;
            } else {
                resortListNode.next = L2;
                L2 = L2.next;
            }
            resortListNode = resortListNode.next;
        }
        if (L1 != null) {
            resortListNode.next = L1;
        }
        if (L2 != null) {
            resortListNode.next = L2;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(10);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(5);

        ListNode l3 = mergeTwoList2(l1, l2);
        while (l3 != null) {
            System.out.print(l3.val + " ");
            l3 = l3.next;
        }
    }
}
