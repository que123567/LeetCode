package medium;

import DataStructure.TreeNode;

/**
 * 114. Flatten Binary Tree to Linked List
 *
 * Given the root of a binary tree, flatten the tree into a "linked list":
 *
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 *
 */
class LeetCode114 {

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.makeTree_Test_Case_3();
        TreeNode.travelTree(treeNode);
    }
}