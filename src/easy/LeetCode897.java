package easy;

import DataStructure.TreeNode;

/**
 * 897. Increasing Order Search Tree
 * .
 * Given a tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.
 * .
 * Example 1:
 * Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * .
 * 5
 * /   \
 * 3     6
 * / \     \
 * 2   4     8
 * /         / \
 * 1         7   9
 * .
 * Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * .
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 * \
 * 7
 * \
 * 8
 * \
 * 9
 */
public class LeetCode897 {

    public TreeNode increasingBST(TreeNode root) {
        return increasingBST(root, null);
    }

    public TreeNode increasingBST(TreeNode root, TreeNode tail) {
        if (root == null) return tail;
        TreeNode res = increasingBST(root.left, root);
        root.left = null;
        root.right = increasingBST(root.right, tail);
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(6);

        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.right = new TreeNode(8);

        treeNode.left.left.left = new TreeNode(1);
        treeNode.right.right.left = new TreeNode(7);
        treeNode.right.right.right = new TreeNode(9);

        LeetCode897 solution = new LeetCode897();
        TreeNode res = solution.increasingBST(treeNode);


    }
}
