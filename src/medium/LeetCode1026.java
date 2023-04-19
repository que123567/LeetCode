package medium;

import DataStructure.TreeNode;

import java.sql.PreparedStatement;

/**
 * 1026. 节点与其祖先之间的最大差值
 * https://leetcode.cn/problems/maximum-difference-between-node-and-ancestor/
 * <p>
 * 给定二叉树的根节点 root，找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
 * <p>
 * （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
 */
public class LeetCode1026 {


    static class Solution_1 {
        public int maxAncestorDiff(TreeNode root) {
            return travelRoot(root, root.val, root.val);
        }

        public int travelRoot(TreeNode root, int minVal, int maxVal) {
            if (root == null) {
                return 0;
            }
            int maxDiff = Math.max(Math.abs(root.val - minVal), Math.abs(root.val - maxVal));
            minVal = Math.min(minVal, root.val);
            maxVal = Math.max(maxVal, root.val);
            int a = travelRoot(root.left, minVal, maxVal);
            int b = travelRoot(root.right, minVal, maxVal);
            a = Math.max(a, b);
            return Math.max(a,maxDiff);
        }


    }

    public static void main(String[] args) {
        Solution_1 solution_1 = new Solution_1();
        TreeNode a = TreeNode.makeTree_Test_Case_3();

    }

}
