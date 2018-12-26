package easy;

import DataStructure.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 出错
 * Runtime Error Message:
 Line 82: java.lang.IndexOutOfBoundsException: Index: 1, Size: 1
 Last executed input:
                        [0]
                     [7,3]
 */
public class LeetCode455_2
{

    static ListNode ArrayListToListNode(List<Integer> list) {
        ListNode tmpListNode = new ListNode(0);
        ListNode tmpHead = new ListNode(0);
        tmpListNode = tmpHead;
        for (int i = 0; i < list.size(); i++) {
            tmpListNode.val = list.get(i);
            if (i != list.size() - 1)
                tmpListNode.next = new ListNode(-1);
            tmpListNode = tmpListNode.next;
        }
        //  Utils.TravelListNode(tmpHead);
        return tmpHead;
    }

    static List ListNodeToArrayList(ListNode list) {
        List<Integer> tmpArray = new ArrayList();
        while (list != null) {
            tmpArray.add(list.val);
            list = list.next;
        }
        return tmpArray;
    }

    static List AddTwoArrayList(List<Integer> l1, List<Integer> l2) {
        /**
         l1:   8 9 7
         l2:   9 2 3
         res:1 8 2 0----->

         reverse:
         l1:   7 9 8
         l2:   3 2 9
         res:  0 2 8 1

         reverse :
         1 8 2 0----->
         */
        List<Integer> tmpRes = new ArrayList<>();
        Collections.reverse(l1);
        Collections.reverse(l2);


        int listMinCount = Math.min(l1.size(), l2.size());
        int listMaxCount = Math.max(l1.size(), l2.size());


        for (int i = 0; i < listMinCount; i++) {
            tmpRes.add((l1.get(i) + l2.get(i)) % 10);
            if ((l1.get(i) + l2.get(i)) >= 10) {
                tmpRes.add(0);
                tmpRes.set(i + 1, tmpRes.get(i) + 1);//前一位进位
            }
        }
        for (int i = listMinCount; i < listMaxCount; i++) {
            if (l1.size() - l2.size() > 0) { //判断哪一个链表偏长
                tmpRes.add(l1.get(i));
                if ((l2.size() > i - 1) && ((l1.get(i - 1) + l2.get(i - 1)) >= 10)) {
                    tmpRes.set(i, tmpRes.get(i) + 1);
                }
            } else {
                tmpRes.add((l2.get(i)));
                if ((l1.size() > i - 1) && ((l1.get(i) + l2.get(i)) >= 10)) {
                    tmpRes.add(0);
                    tmpRes.set(i, tmpRes.get(i) + 1);
                }
            }
        }
        Collections.reverse(tmpRes);
        return tmpRes;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> resOne = ListNodeToArrayList(l1);
        List<Integer> resTwo = ListNodeToArrayList(l2);

        List<Integer> finalArrayList = AddTwoArrayList(resOne, resTwo);

        Collections.reverse(finalArrayList);


        ListNode finalListNode = ArrayListToListNode(finalArrayList);


        return finalListNode;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(5);
//        listNode.next = new ListNode(5);
//        listNode.next.next = new ListNode(5);

        ListNode newListNode = new ListNode(5);
        newListNode.next = new ListNode(5);
//        newListNode.next.next = new ListNode(5);

        List<Integer> res = ListNodeToArrayList(listNode);
        List<Integer> newRes = ListNodeToArrayList(newListNode);


        List<Integer> finalArrayList = AddTwoArrayList(res, newRes);

        ListNode fnalListNode = ArrayListToListNode(finalArrayList);

     //   Utils.TravelListNode(fnalListNode);

    }
}
