/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 * <p>
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * <p>
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 * <p>
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 * <p>
 * Credits:
 * Special thanks to @DjangoUnchained for adding this problem and creating all test cases.
 */

//奇数位和奇数位连接，偶数同理。最后把偶数头接入奇数尾
public class LeetCode328 {
    static class ListNode {
        public ListNode(int value) {
            this.val = value;
        }

        int val;
        ListNode next;
    }

    static class Solution {
        public static ListNode oddEvenList(ListNode head) {
            if (head == null)
                return null;
            ListNode odd=head, even=odd.next, evenHead=head;
            while (even != null && even.next != null) {
                odd.next = odd.next.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
            }
            evenHead = odd.next;
            return evenHead;
        }

    }

}
