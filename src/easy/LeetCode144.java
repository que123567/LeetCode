package easy;


import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode144 {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root, res);
        return res;
    }

    public static void traversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        traversal(root.left, list);
        traversal(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.makeTree_Test_Case_3();
        List<Integer> res = preorderTraversal(treeNode);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }

}
