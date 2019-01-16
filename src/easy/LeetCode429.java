package easy;

import DataStructure.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N-ary Tree Level Order Traversal
 * Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * '
 * For example, given a 3-ary tree:
 * We should return its level order traversal:
 * [
 * [1],
 * [3,2,4],
 * [5,6]
 * ]
 * Note:
 * '
 * The depth of the tree is at most 1000.
 * The total number of nodes is at most 5000.
 */
public class LeetCode429 {
    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node tempNode = queue.poll();
                curLevel.add(tempNode.val);
                if (tempNode.children != null) {
                    for (Node c : tempNode.children) {
                        queue.offer(c);
                    }
                }
            }
            res.add(curLevel);
        }
        return res;
    }


    public static void main(String[] args) {
        var res = levelOrder(Node.makeNodeTree_case_1());
        for (List<Integer> list : res) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
