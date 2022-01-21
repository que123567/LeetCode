package easy;

import DataStructure.ListNode;
import DataStructure.Utils;

import java.util.Arrays;

/**
 * 83. Remove Duplicates from Sorted List
 * Easy
 * 
 * 896
 * 
 * 86
 * 
 * Favorite
 * 
 * Share
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 
 * Example 1:
 * 
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 * 
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class LeetCode83 {
    static class Solution {
        public static ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode cur = head;
            while (cur.next != null) {
                if (cur.val == cur.next.val) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }
            return head;
        }

        public static void main(String[] args) {
            //test case1
            ListNode listNode1 = Utils.getInstance().createListNodeByList(Arrays.asList(1, 2, 2, 3, 3, 4, 5, 6, 7, 7, 7, 8));
            //test case2
            ListNode listNode2 = Utils.getInstance().createListNodeByList(Arrays.asList());
            Utils.getInstance().TraverListNode(Solution.deleteDuplicates(listNode1));
            System.out.println();
            Utils.getInstance().TraverListNode(Solution.deleteDuplicates(listNode2));
        }
    }
}
