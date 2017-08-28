import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

class LeetCode2 {
    static class ListNode {
        public ListNode(int value) {
            this.val = value;
        }

        int val;
        ListNode next;
    }

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
        if (isCarry[checkCount - 1] == true) {
            resList.next = new ListNode(1);
            resList = resList.next;
        }
        return tmp;
    }

    public static void main(String[] args) {
        //1->2->3  3->8->5   4->0->9  321+583=904 √
        //7-2-3 3-8-5 0-1-9  327+583=910 √
        //7-2-5 3-8-5 0-1-1  527+583=1110
        //9-2 8-8  7-1-1  99+88=117
        //2-7 9-0 1-8  72+9 =81
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
//        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
        //     l2.next = new ListNode(8);
//        l2.next.next = new ListNode(5);

        ListNode l3 = addTwoNumbers(l1, l2);
        while (l3 != null) {
            System.out.println("l3.val:" + l3.val);
            l3 = l3.next;
        }
    }

}