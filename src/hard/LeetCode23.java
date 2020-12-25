package hard;

import DataStructure.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. Merge k Sorted Lists
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * .
 * Example:
 * .
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class LeetCode23 {

    /**
     * Version 1
     * 每两两合并,最后合并为1个
     */
    static class Solution1 {
        public static ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            return mergeKList(lists, 0, lists.length - 1);
        }

        public static ListNode mergeKList(ListNode[] lists, int left, int right) {
            if (left == right) {
                return lists[left];
            } else if (left < right) {
                int mid = left + (right - left) / 2;//避免溢出
                ListNode leftNode = mergeKList(lists, left, mid);
                ListNode rightNode = mergeKList(lists, mid + 1, right);
                return mergeTwoLists(leftNode, rightNode);
            } else {
                return null;
            }
        }

        /**
         * merge sort
         *
         * @param l1
         * @param l2
         * @return
         */
        public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null || l2 == null) {
                return l2 == null ? l1 : l2;
            }
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            if (l1 != null) {
                cur.next = l1;
            }
            if (l2 != null) {
                cur.next = l2;
            }
            return dummy.next;
        }
    }

    /**
     * [
     * 1->4->5,
     * 1->3->4,
     * 2->6
     * ]
     * <p>
     * tail
     * 1--->---4---->5
     * [
     * 4->5,
     * 1->3->4,
     * 2->6
     * ]
     * <p>
     * tail
     * 1---->1---->3---->4
     * [
     * 2->6,
     * 3->4,
     * 4->5
     * ]
     */
    static class Solution2 {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0)
                return null;
            PriorityQueue<ListNode> listNodeQueue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return Integer.compare(o1.val, o2.val);
                }
            });
            for (ListNode node : lists) {
                if (node != null) {
                    listNodeQueue.add(node);
                }
            }
            ListNode dummy = new ListNode(0), tail = dummy;
            while (!listNodeQueue.isEmpty()) {
                tail.next = listNodeQueue.poll();
                tail = tail.next;
                if (tail.next != null) {
                    listNodeQueue.add(tail.next);
                }
            }
            return dummy.next;
        }

    }

    /**
     * len=7  len/2=3    i=0;1;2      √ :sorted
     * 0√            0 -  0merge1
     * <p>
     * 1√    2√         1 -  2merge3
     * 2 -  4merge5
     * 3  4   5  6
     * <p>
     * len=4  len/2=2     i=0;1       √ :sorted
     * 0 √         0 -  0merge1
     * <p>
     * 1√    2        1 -  2merge6
     * <p>
     * 6
     * <p>
     * len=2  len/2=1    i=0;         √ :sorted
     * 0√         0 -  0merge1
     * <p>
     * 1
     */
    static class Solution3 {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            int len = lists.length;
            while (len != 1) {
                for (int i = 0; i < len / 2; i++) {
                    lists[i] = mergeTwo(lists[i * 2], lists[i * 2 + 1]);
                }
                if (len % 2 == 1) {
                    lists[len / 2] = lists[len - 1];
                }
                len = (len + 1) / 2;
            }
            return lists[0];
        }

        private ListNode mergeTwo(ListNode l1, ListNode l2) {
            if (l1 == null || l2 == null) {
                return l1 == null ? l2 : l1;
            }
            ListNode dummy = new ListNode(0), tail = dummy;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    tail.next = l1;
                    l1 = l1.next;
                } else {
                    tail.next = l2;
                    l2 = l2.next;
                }
                tail = tail.next;
            }

            if (l1 != null) {
                tail.next = l1;
            }
            if (l2 != null) {
                tail.next = l2;
            }
            return dummy.next;
        }
    }

    static class Solution4 {
        public static ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) {
                return null;
            }
            if (lists.length == 1) {
                return lists[0];
            }
            int middle = lists.length / 2;
            ListNode[] leftNode = Arrays.copyOfRange(lists, 0, middle);
            ListNode[] rightNode = Arrays.copyOfRange(lists, middle, lists.length);

            ListNode left = mergeKLists(leftNode);
            ListNode right = mergeKLists(rightNode);

            return merge2Lists(left, right);
        }

        public static ListNode merge2Lists(ListNode l1, ListNode l2) {
            if (l1 == null || l2 == null) {
                return l1 == null ? l2 : l1;
            }
            if (l1.val < l2.val) {
                l1.next = merge2Lists(l1.next, l2);
                return l1;
            } else {
                l2.next = merge2Lists(l1, l2.next);
                return l2;
            }
        }

        public static void main(String[] args) {
            ListNode listNode1 = ListNode.makeListNodeTestCase5();
            ListNode listNode2 = ListNode.makeListNodeTestCase2();
            ListNode listNode3 = ListNode.makeListNodeTestCase3();
            ListNode listNode4 = ListNode.makeListNodeTestCase4();

            ListNode[] listNodes = new ListNode[]{listNode1, listNode2, listNode4, listNode3};
            ListNode listNodeFinal = mergeKLists(listNodes);

            while (listNodeFinal != null) {
                System.out.print(listNodeFinal.val + " < ");
                listNodeFinal = listNodeFinal.next;
            }

        }
    }


    public static void main(String[] args) {
        ListNode list1 = ListNode.makeListNodeTestCase2();
        ListNode list2 = ListNode.makeListNodeTestCase3();
        ListNode list3 = ListNode.makeListNodeTestCase4();
        ListNode[] list = new ListNode[]{list1, list2, list3};
        var res1 = Solution1.mergeKLists(list);
        while (res1 != null) {
            System.out.print(res1.val + " ");
            res1 = res1.next;
        }
    }
}
