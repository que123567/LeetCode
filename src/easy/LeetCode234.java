package easy;

import DataStructure.ListNode;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * .
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class LeetCode234 {


    static class Solution {
        public static boolean isPalindrome(ListNode head) {
            return false;
        }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(3);
        a.next.next = new ListNode(2);
        a.next.next.next = new ListNode(4);


        ListNode c = new ListNode(1);
        c.next = new ListNode(3);
        c.next.next = new ListNode(2);
        c.next.next.next = new ListNode(1);
    }

}
