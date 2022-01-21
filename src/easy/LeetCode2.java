package easy;

import DataStructure.ListNode;
import DataStructure.Utils;

import javax.swing.plaf.metal.MetalInternalFrameTitlePane;
import java.util.ArrayList;
import java.util.List;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Example:
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

class LeetCode2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean[] isCarry;//是否进位
        List<Integer> list1Res = new ArrayList();
        List<Integer> list2Res = new ArrayList();
        while (l1 != null || l2 != null) {

            if (l1 != null && l2 != null) {
                list1Res.add(l1.val);
                list2Res.add(l2.val);
                l1 = l1.next;
                l2 = l2.next;
            }
            if (l1 != null && l2 == null) {
                list1Res.add(l1.val);
                list2Res.add(0);
                l1 = l1.next;
            }
            if (l1 == null && l2 != null) {
                list1Res.add(0);
                list2Res.add(l2.val);
                l2 = l2.next;
            }
        }

        int checkCount = Math.max(list1Res.size(), list2Res.size());
        isCarry = new boolean[checkCount];

        List<Integer> listAddRes = new ArrayList(3);

        for (int i = 0; i < checkCount; i++) {//循环,记录是否进位。
            int val1 = list1Res.get(i);
            int val2 = list2Res.get(i);
            if (val1 + val2 >= 10) {
                isCarry[i] = true;
            }
            listAddRes.add(val1 + val2);
        }
        ListNode tmp = new ListNode(-1);
        ListNode resList = tmp;
        for (int i = 0; i < checkCount; i++) {
            resList.val = listAddRes.get(i) % 10;
            if (i > 0 && isCarry[i - 1]) {//  前一位进位 后一位加一
                if (resList.val != 9)
                    resList.val += 1;
                else {
                    resList.val = 0;
                    isCarry[i] = true;
                }
            }
            //  System.out.println(resList.val); //最后一位相加进一，链表增加一位。
            if (i != checkCount - 1) {
                resList.next = new ListNode(-1);
                resList = resList.next;
            }
        }
        if (isCarry[checkCount - 1]) {
            resList.next = new ListNode(1);
            resList = resList.next;
        }
        return tmp;
    }


    public static ListNode addTwoNumbres_new(ListNode l1, ListNode l2) {
        ListNode dummyHead = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int sum = v1 + v2 + carry;
            carry = sum / 10;
            if (dummyHead == null) {
                dummyHead = new ListNode(sum % 10);
                tail = dummyHead;
            }else{
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            if (carry != 0) {
                tail.next = new ListNode(carry);
            }
        }
        return dummyHead;
    }

    public static void main(String[] args) {
        //1->2->3  3->8->5   321+583=904 √
        //7-2-3 3-8-5 0-1-9  327+583=910 √
        //7-2-5 3-8-5 0-1-1  527+583=1110
        //9-2 8-8  7-1-1  99+88=117
        //2-7 9-0 1-8  72+9 =81
        //
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(8);
        l2.next.next = new ListNode(5);

        ListNode l3 = addTwoNumbres_new(l1, l2);
        Utils.getInstance().TraverListNode(l3);
    }

}