import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 * <p>
 * For example, given a 3-ary tree:
 * 1
 * /  |  \
 * 3   2  4
 * / \
 * 5  6
 * <p>
 * Return its preorder traversal as: [1,3,5,6,2,4].
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * Recursive solution is trivial, could you do it iteratively?
 */
public class LeetCode589 {

    /**
     * Node
     */
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
     * @param root
     * @return
     */
    public static List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            list.add(currentNode.val);
            if (currentNode.children != null) {
                for (Node node : currentNode.children) {
                    queue.offer(node);
                }
            }
        }
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

        List<Integer> list = preorder(node);
        for (int i : list) {
            System.out.print(i+" ");
        }
    }
}
