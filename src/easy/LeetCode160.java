package easy;

import DataStructure.ListNode;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * <p>
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 */
public class LeetCode160 {

    /**
     * 此方法相当于把链表分别成两条一样长度的组成链表,最后由于两条链表连接起来长度相等,也一起迭代,最终会一起迭代到重叠部分.
     * 1->2->3
     *        ->8->13
     *    7->5
     *
     * 1->2->3->8->13->7->5->8->13
     * 7->5->8->13->1->2->3->8->13
     *
     * 可见:最终由于2条链表长度相等,且属于共同迭代,最终一定会一起迭代到重叠部分(上例为8)
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(6);
        listNode.next.next = new ListNode(4);
//        listNode.next.next.next = new ListNode(4);
//        listNode.next.next.next.next = new ListNode(5);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(5);
//        listNode2.next.next = new ListNode(1);
//        listNode2.next.next = listNode.next.next;

      getIntersectionNode(listNode, listNode2);
    }

}
