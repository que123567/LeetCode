package easy;

import DataStructure.TreeNode;

/**
 * 538. Convert BST to Greater Tree
 * .
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
 * .
 * Example:
 * .
 * Input: The root of a Binary Search Tree like this:
 *          5
 *        /   \
 *       2     13
 * .
 * Output: The root of a Greater Tree like this:
 *         18
 *        /   \
 *      20     13
 */
public class LeetCode538 {
    static int sum = 0;

    public static TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }

    public static void convert(TreeNode root) {
        if (root == null) {
            return;
        }
        convertBST(root.right);
        root.val += sum;
        sum = root.val;
        convertBST(root.left);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.makeTree_Test_Case_1();
        convert(treeNode);
        TreeNode.travelTree(treeNode);
    }
}
