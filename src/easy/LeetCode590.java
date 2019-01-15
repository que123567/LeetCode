package easy;

import DataStructure.Node;
import DataStructure.TreeNode;

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
     * version1
     */
    public static List<Integer> postorder(Node root) {
        LinkedList<Integer> list = new LinkedList();
        if (root == null)
            return list;

        Stack<Node> s = new Stack();
        s.push(root);

        while (!s.isEmpty()) {
            Node temp = s.pop();
            list.addFirst(temp.val);
            System.out.println(temp.val);
            if (temp.children != null) {
                for (Node n : temp.children) {
                    s.push(n);
                }
            }
        }
        return list;

    }

    /**
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
        Node node = new Node();
        node.val = 1;

        Node node1 = new Node();
        node1.val = 3;
        Node node2 = new Node();
        node2.val = 2;
        Node node3 = new Node();
        node3.val = 4;
        List<Node> nodeList = new ArrayList<>();
        nodeList.add(node1);
        nodeList.add(node2);
        nodeList.add(node3);
        node.children = nodeList;

        Node node4 = new Node();
        node4.val = 5;
        Node node5 = new Node();
        node5.val = 6;

        List<Node> nodeList1 = new ArrayList<>();
        nodeList1.add(node4);
        nodeList1.add(node5);

        node1.children = nodeList1;

        List<Integer> res = postOrder(node);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
