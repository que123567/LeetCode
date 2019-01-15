package DataStructure;


import java.util.ArrayList;
import java.util.List;

public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    /**
     * 测试用例1
     *
     * @return
     */
    public static Node makeNodeTree_case_1() {
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

        return node;
    }
}

