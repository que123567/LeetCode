package hard;

import DataStructure.ListNode;

/**
 * 23. Merge k Sorted Lists
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class LeetCode23 {

    /**
     * Version 1
     * 每两两合并,最后合并为1个
     */
    static class Solution1 {
        public static ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            return mergeKList(lists, 0, lists.length - 1);
        }

        public static ListNode mergeKList(ListNode[] lists, int left, int right) {
            if (left == right) {
                return lists[left];
            } else if (left < right) {
                int mid = left + (right - left) / 2;//避免溢出
                ListNode leftNode = mergeKList(lists, left, mid);
                ListNode rightNode = mergeKList(lists, mid + 1, right);
                return mergeTwoLists(leftNode, rightNode);
            } else {
                return null;
            }
        }

        /**
         * merge sort
         * @param l1
         * @param l2
         * @return
         */
        public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null || l2 == null) {
                return l2 == null ? l1 : l2;
            }
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
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
            return dummy.next;
        }

    }


    public static void main(String[] args) {
        ListNode list1 = ListNode.makeListNodeTestCase2();
        ListNode list2 = ListNode.makeListNodeTestCase3();
        ListNode list3 = ListNode.makeListNodeTestCase4();
        ListNode[] list = new ListNode[]{list1, list2, list3};
        var res1 = Solution1.mergeKLists(list);
        while (res1 != null) {
            System.out.print(res1.val + " ");
            res1 = res1.next;
        }
    }
}
