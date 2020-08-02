package medium;

import DataStructure.ListNode;

import java.util.List;

/**
 *86. Partition List
 *Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Example:
 *
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 *
 */
public class LeetCode86 {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyL = new ListNode(0), dummyR = new ListNode(0);
        ListNode currL = dummyL, currR = dummyR;
        while (head != null) {
            if (head.val < x) {
                currL.next = head;
                currL = head;
            }else {
                currR.next = head;
                currR = head;
            }
            head = head.next;
        }
        currL.next = dummyR.next;
        currR.next = null;
        return dummyL.next;
    }

    public ListNode partition_(ListNode head, int x) {
        ListNode dummySmall = new ListNode(0), dummyLarge = new ListNode(0);
        ListNode curSmall = dummySmall, curLarge = dummyLarge;
        while (head != null) {
            if (head.val <= x) {
                curSmall.next = head;
                curSmall = head;
            } else {
                curLarge.next = head;
                curLarge = head;
            }
            head = head.next;
        }
        curSmall.next = dummyLarge.next;
        curLarge.next = null;
        return dummySmall.next;
    }

    public static void main(String[] args) {

     }
}
