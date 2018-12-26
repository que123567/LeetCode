package medium;

import DataStructure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 817. Linked List Components
 * .
 * We are given head, the head node of a linked list containing unique integer values.
 * .
 * We are also given the list G, a subset of the values in the linked list.
 * .
 * Return the number of connected components in G, where two values are connected if they appear consecutively in the linked list.
 * .
 * Example 1:
 * .
 * Input:
 * head: 0->1->2->3
 * G = [0, 1, 3]
 * Output: 2
 * Explanation:
 * 0 and 1 are connected, so [0, 1] and [3] are the two connected components.
 * Example 2:
 * .
 * Input:
 * head: 0->1->2->3->4
 * G = [0, 3, 1, 4]
 * Output: 2
 * Explanation:
 * 0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected components.
 */
public class LeetCode817 {

    public static int numCoponets(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int i : G) {
            set.add(i);
        }
        int res = 0;
        while (head != null) {
            //此处head.next==null既作为判空,也作为单component情况下的特殊考虑,比较巧妙
            if (set.contains(head.val) && (head.next == null || !set.contains(head.next.val))) {
                res++;
            }
            head = head.next;
        }
        return res;
    }

    //head: 0->1->2->3->4->5->6
    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next.next = new ListNode(6);

        int[] G = new int[]{0,3,5,6};
        System.out.println(numCoponets(l1, G));

    }

}
