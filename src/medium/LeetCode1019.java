package medium;

import DataStructure.ListNode;
import DataStructure.Utils;

import java.util.*;

public class LeetCode1019 {
    public static void main(String[] args) {

        ListNode listNode = Utils.getInstance().createListNodeByList(Arrays.asList(1, 7, 5, 1, 9, 2, 5, 1));
//        int[] res = nextLargerNodes(listNode);
        int[] res = nextLargerNodes_V2(listNode);
        for (int i = 0; i < res.length; i++) {
//            System.out.print(res[i] + " ");
        }
    }

    /**
     * version 1
     * Accepted	 1122 ms	40.8 MB	 java
     *
     * @param head
     * @return
     */
    public static int[] nextLargerNodes(ListNode head) {
        List<Integer> res = new ArrayList<>();
        while (head != null) {
            res.add(findNext(head));
            head = head.next;
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    private static int findNext(ListNode tempNode) {
        int cmpVal = tempNode.val;
        while (tempNode.next != null) {
            if (tempNode.next.val > cmpVal) {
                return tempNode.next.val;
            }
            tempNode = tempNode.next;
        }
        return 0;
    }

    
    /**
     * version 2
     *
     * @param head
     * @return
     */
    public static int[] nextLargerNodes_V2(ListNode head) {
        ArrayList<Integer> nodeList = new ArrayList<>();
        for (ListNode node = head; node != null; node = node.next)
            nodeList.add(node.val);
        int[] res = new int[nodeList.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nodeList.size(); ++i) {
            while (!stack.isEmpty() && nodeList.get(stack.peek()) < nodeList.get(i))
                res[stack.pop()] = nodeList.get(i);
            stack.push(i);
            System.out.println(i);
        }
        return res;
    }

    /**
     * version 3
     * 1.Use ArrayList to save the value of each node;
     * 2.Use Stack to maintain the indices of a descending sequence;
     * 3.Traverse the ListNodes, whenever encountering a new node greater than the element corresponding to the top of the stack, keep popping it out till the stack is empty or the new one is no longer greater; For each poped out index, set the corresponding element in the ArrayList with the new node value.
     * 4.After the traversal, those remaining in stack are indices of elements without next greater node; Set them to 0.
     *
     * @param head
     * @return
     */
    public static int[] nextLargerNodes_V3(ListNode head) {
        List<Integer> l = new ArrayList<>();
        Deque<Integer> s = new ArrayDeque<>();
        for (ListNode n = head; n != null; n = n.next) {
            while (!s.isEmpty() && n.val > l.get(s.peek())) {
                l.set(s.pop(), n.val);
            } // see 3. for details.
            s.push(l.size()); // push into stack the index of the element that has not found next greater node yet.
            l.add(n.val); // add the new node value.
        }
        for (int i : s) {
            l.set(i, 0);
        } // now stack contains only indices of nodes without next greater node.
        return l.stream().mapToInt(i -> i).toArray(); // convert ArrayList to int[].
    }
}
