package easy;

import DataStructure.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
 * .
 * For example, given a 3-ary tree:
 * 1
 * /  |  \
 * 3   2   4
 * / \
 * 5   6
 * Return its postorder traversal as: [5,6,3,2,4,1].
 */
public class LeetCode590 {
    /**
     * Iteration
     * version1
     */
    public static List<Integer> postorder(Node root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            list.addFirst(temp.val);
            if (temp.children != null) {
                for (Node node : temp.children) {
                    stack.push(node);
                }
            }
        }
        return list;
    }

    /**
     * Recursion
     * version2
     *
     * @param root
     * @return
     */
    static List<Integer> list = new ArrayList<>();

    public static List<Integer> postOrder(Node root) {
        if (root == null)
            return list;

        if (root.children != null) {
            for (Node node : root.children)
                postOrder(node);
        }

        list.add(root.val);
        return list;
    }

    public static void main(String[] args) {
        Node node = Node.makeNodeTree_case_1();
        List<Integer> res = postorder(node);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
