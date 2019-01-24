package easy;

import DataStructure.ListNode;

/**
 * 234. Palindrome Linked List
 * .
 * Given a singly linked list, determine if it is a palindrome.
 * .
 * Example 1:
 * .
 * Input: 1->2
 * Output: false
 * Example 2:
 * .
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class LeetCode234 {


    static class Solution {
        public static boolean isPalindrome(ListNode head) {
            ListNode walker = head, runner = head;
            while (runner != null && runner.next != null) {
                walker = walker.next;
                runner = runner.next.next;
            }
            if (runner != null) {
                walker = walker.next;//It's a odd node,skip it.
            }

            walker = reverseNode(walker);
            runner = head;
            while (walker != null) {
                if (walker.val != runner.val) {
                    return false;
                }
                walker = walker.next;
                runner = runner.next;
            }
            return true;
        }

        public static ListNode reverseNode(ListNode head) {
            ListNode prev = null;
            while (head != null) {
                ListNode next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }
            return prev;
        }
    }

    public static void main(String[] args) {
        ListNode case1 = ListNode.makeListNodeTestCase1();
        ListNode case2 = ListNode.makeListNodeTestCase2();
        ListNode case3 = ListNode.makeListNodeTestCase3();
        ListNode case4 = ListNode.makeListNodeTestCase4();
        ListNode case5 = ListNode.makeListNodeTestCase5();

        System.err.println(Solution.isPalindrome(case1));
        System.err.println(Solution.isPalindrome(case2));
        System.err.println(Solution.isPalindrome(case3));
        System.err.println(Solution.isPalindrome(case4));
        System.err.println(Solution.isPalindrome(case5));
    }

}
