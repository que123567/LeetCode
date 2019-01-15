package easy;

import DataStructure.Node;

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
        Node node =Node.makeNodeTree_case_1();

        System.out.println(maxDepth_2(node));

    }
}
