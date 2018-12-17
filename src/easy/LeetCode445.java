package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first
 * and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * <p>
 * Example:
 * <p>
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */
public class LeetCode445 {

    static class ListNode {
        public ListNode(int value) {
            this.val = value;
        }

        int val;
        ListNode next;
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int num1 = ListToArray(l1);
            int num2 = ListToArray(l2);
            num1 += num2;
            return ArrayToList(num1);
        }
    }

    static int ListToArray(ListNode list) {
        int tmpArray = 0;
        while (list != null) {
            tmpArray = tmpArray * 10 + list.val;
            list = list.next;
        }
       System.out.println("ListToArray" + tmpArray);
        return tmpArray;
    }

    static ListNode ArrayToList(int array) {
        //1236-> 6-3-2-1
        // ------ 1->2->3->6
        ListNode tmpListNode = new ListNode(-1);//结果链表
        ListNode tmpHead = new ListNode(0);
        tmpListNode = tmpHead;
        List<Integer> tmpArray = new ArrayList();// 结果暂存在动态数组中

        while (array != 0) {
            tmpArray.add(array % 10);
            array /= 10;
        }
        Collections.reverse(tmpArray);//反转ArrayList

        for (int i = 0; i < tmpArray.size(); i++) {
            tmpListNode.val = tmpArray.get(i);
            if (i < tmpArray.size() - 1)//到最后一位不新建链表
                tmpListNode.next = new ListNode(-1);
            tmpListNode = tmpListNode.next;
        }
        return tmpHead;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(7);
//        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(4);

        int num1 = ListToArray(l1);
        int num2 = ListToArray(l2);
        num1 += num2;
        ListNode node = ArrayToList(num1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
