package easy;

import DataStructure.ListNode;

/**
 * 876. Middle of the Linked List
 * .
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * .
 * If there are two middle nodes, return the second middle node.
 * .
 * .
 * .
 * Example 1:
 * .
 * Input: [1,2,3,4,5]
 * Output: Node 3 from this list (Serialization: [3,4,5])
 * The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
 * Note that we returned a ListNode_ object ans, such that:
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
 * Example 2:
 * .
 * Input: [1,2,3,4,5,6]
 * Output: Node 4 from this list (Serialization: [4,5,6])
 * Since the list has two middle nodes with values 3 and 4, we return the second one.
 */
public class LeetCode876 {
    public static ListNode middleNode(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;
        while (runner != null && runner.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }
        return walker;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
//        l1.next.next.next = new ListNode_(4);
//        l1.next.next.next.next = new ListNode_(5);
//        l1.next.next.next.next.next = new ListNode_(6);
        ListNode node = middleNode(l1);
        System.out.println(node.val);
    }
}
