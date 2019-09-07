package easy;

import DataStructure.ListNode;
import DataStructure.Utils;

/**
 * Remove all elements from a linked list of integers that have value val.
 * .
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 * .
 * Credits:
 * Special thanks to @mithmatt for adding this problem and creating all test cases.
 */
public class LeetCode203 {


    static class Solution {
        public static ListNode removeElements(ListNode head, int val) {
            if (head == null) return null;
            head.next = removeElements(head.next, val);
            return head.val == val ? head.next : head;
        }

        // DUMMY----->1------>3------>2------>-----4----->7
        // pre   head/cur
        public static ListNode removeElements_new(ListNode head, int val) {
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode curNode = head;
            ListNode preNode = dummyHead;
            while (curNode != null) {
                if (curNode.val == val) {
                    preNode.next = curNode.next;//值相等 ，跳过当前node。
                } else {
                    preNode = preNode.next;//preNode必须停留在最后一个非val的点，不能和curNode同步用.next方法遍历（如下注释代码为错）
                }
                //preNode=preNode.next;
                curNode = curNode.next;
            }
            return dummyHead.next;
        }

        public static void main(String[] args) {
            ListNode a = new ListNode(1);
            a.next = new ListNode(3);
            a.next.next = new ListNode(2);
            a.next.next.next = new ListNode(4);
            a.next.next.next.next = new ListNode(7);

            removeElements(a, 7);
            //travel
            Utils.getInstance().TraverListNode(a);
        }
    }
}
