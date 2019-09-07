package InterviewGuidance;

import DataStructure.DoubleListNode;
import DataStructure.ListNode;
import DataStructure.Utils;

import javax.xml.crypto.KeySelector;

public class ReverseLinkedList {
    public static class Solution {
        public static void main(String[] args) {
            ListNode listNode = ListNode.makeListNodeTestCase5();
            Utils.getInstance().TraverListNode(reverseLinkedList(listNode));

        }

        public static ListNode reverseLinkedList(ListNode head) {
            ListNode pre = null;
            ListNode next;
            while (head != null) {
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            return pre;
        }

    }

}
