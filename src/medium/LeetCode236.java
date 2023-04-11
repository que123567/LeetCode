package medium;

import DataStructure.TreeNode;


public class LeetCode236 {

    /**
     * 情况 1，如果p和q都在以root为根的树中，那么left和right一定分别是p和q（从 base case 看出来的）。
     * 
     * 情况 2，如果p和q都不在以root为根的树中，直接返回null。
     * 
     * 情况 3，如果p和q只有一个存在于root为根的树中，函数返回该节点。
     * 
     * 
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null)
            return null;

        if (root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 情况 1
        if (left != null && right != null) {
            return root;
        }
        // 情况 2
        if (left == null && right == null) {
            return null;
        }
        // 情况 3
        return left == null ? right : left;
    }

    public int countNodes(TreeNode root) {
        int lh = 0, rh = 0;
        TreeNode left = root, right = root;
        while (left != null) {
            left = left.left;
            lh++;
        }
        while (right != null) {
            right = right.right;
            rh++;
        }
        if (lh == rh) {
            return (int) Math.pow(2, lh) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);

    }


    public static void main(String[] args) {
        TreeNode node1 = TreeNode.makeTree_Test_Case_3();

    }
}
