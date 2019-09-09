package medium;

import DataStructure.ListNode;
import DataStructure.Utils;

/**
 * 19. Remove Nth Node From End of List
 * .
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * .
 * Example:
 * .
 * Given linked list: 1->2->3->4->5, and n = 2.
 * .
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * .
 * Given n will always be valid.
 * .
 * Follow up:
 * .
 * Could you do this in one pass?
 */
public class LeetCode19 {

    /**
     * my version
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        int len = 0;
        for (ListNode node = head; node != null; node = node.next) {
            len++;
        }
        len = len - n;
        ListNode tmpPrev = dummyHead;
        for (int i = 0; i < len; i++) {
            tmpPrev = tmpPrev.next;
        }
        //isn't tail
        if (tmpPrev.next != null && tmpPrev.next.next != null) {
            tmpPrev.next = tmpPrev.next.next;//1->2->3->4->5 ====>jump one node 1->2->3->5
        } else if (tmpPrev.next != null && tmpPrev.next.next == null) {
            //is tail
            tmpPrev.next = null;
        }
        return dummyHead.next;
    }

    public static ListNode removeNthFromEnd_version1(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }

    public static void main(String[] args) {
        ListNode noed1 = ListNode.makeListNodeTestCase5();
        var res1 = removeNthFromEnd_version1(noed1, 2);
        Utils.getInstance().TraverListNode(res1);
    }
}
