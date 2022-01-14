package medium;

import DataStructure.TreeNode;

import java.util.*;

public class LeetCode103 {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> lis = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curNode = queue.poll();
                if (curNode != null) {
                    lis.add(curNode.val);
                    if (curNode.left != null) {
                        queue.add(curNode.left);
                    }
                    if (curNode.right != null) {
                        queue.add(curNode.right);
                    }
                }

            }
            if (res.size() % 2 != 0) {
                Collections.reverse(lis);
            }
            res.add(lis);
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = zigzagLevelOrder(TreeNode.makeTree_Test_Case_3());
        for (List<Integer> a : res) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }
}
