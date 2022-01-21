package medium;

import DataStructure.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class LeetCode382 {
    static class Solution {
        ListNode head;

        public Solution(ListNode head) {
            this.head = head;
        }

        public int getRandom() {
            Random r = new Random();
            int i = 0, res = 0;
            ListNode p = head;
            // while 循环遍历链表
            while (p != null) {
                i++;
                // 生成一个 [0, i) 之间的整数
                // 这个整数等于 0 的概率就是 1/i
                if (0 == r.nextInt(i)) {
                    res = p.val;
                }
                p = p.next;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = ListNode.makeListNodeTestN(50);
        Solution solution = new Solution(node1);
        int[] array = new int[50];

        for (int i = 0; i < 100000; i++) {
            int res = solution.getRandom();
            array[res]++;
        }

        for (int j : array) {
            System.out.println(j);
        }
    }
}
