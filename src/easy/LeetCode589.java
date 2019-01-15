package easy;

import DataStructure.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 * .
 * For example, given a 3-ary tree:
 * 1
 * /  |  \
 * 3   2  4
 * / \
 * 5  6
 * .
 * Return its preorder traversal as: [1,3,5,6,2,4].
 * .
 * .
 * .
 * Note:
 * .
 * Recursive solution is trivial, could you do it iteratively?
 */
public class LeetCode589 {
    /**
     * @param root
     * @return
     */
    public static List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            list.add(currentNode.val);
            if (currentNode.children != null) {
                for (int i = currentNode.children.size() - 1; i >= 0; i--) {
                    stack.push(currentNode.children.get(i));
                }
            }
        }
        return list;
    }

    public static List<Integer> list = new ArrayList<>();

    public static List<Integer> preorder_(Node root) {
        if (root == null)
            return list;

        list.add(root.val);
        for (Node node : root.children)
            preorder_(node);
        return list;
    }

    public static void main(String[] args) {

        Node node = Node.makeNodeTree();

        List<Integer> list = preorder_(null);
        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}
