package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 559. Maximum Depth of N-ary Tree
 * .
 * Given a n-ary tree, find its maximum depth.
 * .
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * .
 * For example, given a 3-ary tree:
 * .
 * 1
 * /   |   \
 * 3    2    4
 * / \
 * 5   6
 * .
 * We should return its max depth, which is 3.
 * .
 * .
 * .
 * Note:
 * .
 * The depth of the tree is at most 1000.
 * The total number of nodes is at most 5000.
 */
public class LeetCode559 {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * recursion
     *
     * @param root
     * @return
     */
    public static int maxDepth(Node root) {
        if (root == null || root.children == null)
            return 0;
        int maxDepth = 0;
        for (Node child : root.children) {
            if (child != null) {
                maxDepth = Math.max(maxDepth, maxDepth(child));
            }
        }
        return maxDepth + 1;
    }

    /**
     * DFS
     *
     * @param root
     * @return
     */
    public static int maxDepth_(Node root) {
        if (root == null)
            return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                for (Node child : current.children)
                    queue.offer(child);
            }

            depth++;
        }

        return depth;
    }

    public static int maxDepth_2(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node currentNode = queue.poll();
                if (currentNode.children != null) {
                    for (Node child : currentNode.children) {
                        queue.offer(child);
                    }
                }
            }
            depth++;
        }
        return depth;
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

        ////
        System.out.println(maxDepth_2(node));

    }
}
