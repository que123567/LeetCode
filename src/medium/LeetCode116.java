package medium;

import DataStructure.TreeNode;

/**
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 */
class LeetCode116 {


    public static TreeNode connect(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        connectTwoNodes(root.left, root.right);
        return root;
    }

    public static void connectTwoNodes(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        node1.next = node2;
        connectTwoNodes(node1.left, node1.right);
        connectTwoNodes(node2.left, node2.right);
        connectTwoNodes(node1.right, node2.left);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.makeTree_Test_Case_3();
        TreeNode nodeResult = connect(treeNode);
        int i = 1;
    }
}