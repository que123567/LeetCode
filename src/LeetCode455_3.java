import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 引用leetco2的代码方法
 */
public class LeetCode455_3
{
    static class ListNode
    {
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
                list2Res.add(0, 0);//在少的位子上补足0
                l1 = l1.next;
            }


            if (l1 == null && l2 != null) {
                list1Res.add(0, 0);
                list2Res.add(l2.val);
                l2 = l2.next;
            }
        }
        //    7-2-4-3  5-6-4 相加为 7807
        //    过程： 7243  0564  反转得： 3427 4650 向右进位得： 7087  翻转得：答案7807
        Collections.reverse(list1Res);
        Collections.reverse(list2Res); //

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
                    isCarry[i] = true;//后一位 进位
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

        tmp = reverseList(tmp);
        return tmp;
    }

    static ListNode reverseList(ListNode listNodeHead) {
        ListNode pRevertHead = null;
        ListNode pNode = listNodeHead;
        ListNode pPrev = null;
        while (pNode != null) {
            ListNode pNext = pNode.next;
            if (pNext == null) {
                pRevertHead = pNode;
            }
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }

        return pRevertHead;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(8);
        l2.next.next = new ListNode(5);
        //993 185
    }

}
