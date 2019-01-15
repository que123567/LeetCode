package easy;

import DataStructure.TreeNode;

/**
 * Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.
 * '
 * Example :
 * '
 * Input: root = [4,2,6,1,3,null,null]
 * Output: 1
 * Explanation:
 * Note that root is a TreeNode object, not an array.
 * '
 * The given tree [4,2,6,1,3,null,null] is represented by the following diagram:
 * '
 * 4
 * /   \
 * 2      6
 * / \
 * 1   3
 * '
 * while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
 * Note:
 * '
 * The size of the BST will be between 2 and 100.
 * The BST is always valid, each node's value is an integer, and each node's value is different.
 */
public class LeetCode783 {
    Integer res = Integer.MAX_VALUE, pre = null;

    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        minDiffInBST(root.left);
        if (pre != null)
            res = Math.min(res, root.val - pre);
        pre = root.val;
        minDiffInBST(root.right);
        return res;
    }

    public static void main(String[] args) {
        LeetCode783 solution = new LeetCode783();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(solution.minDiffInBST(root));

    }
}
