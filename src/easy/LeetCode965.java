package easy;

import DataStructure.TreeNode;

/**
 * 965. Univalued Binary Tree
 * .
 * A binary tree is univalued if every node in the tree has the same value.
 * .
 * Return true if and only if the given tree is univalued.
 * .
 * .
 * .
 * Example 1:
 * .
 * .
 * Input: [1,1,1,1,1,null,1]
 * Output: true
 * Example 2:
 * .
 * .
 * Input: [2,2,2,5,2]
 * Output: false
 */
public class LeetCode965 {
    public static boolean isUnivalTree(TreeNode root) {
        return isUnivalTree(root, root.val);
    }

    public static boolean isUnivalTree(TreeNode node,int value) {
        if (node == null) {
            return true;
        }
        if (node.val != value) {
            return false;
        }
        return isUnivalTree(node.left, value) && isUnivalTree(node.right, value);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        /**
         *       1
         *     /  \
         *    1    1
         *   / \  / \
         *  1  1  1  1
         */
        node.left = new TreeNode(1);
        node.right = new TreeNode(1);

        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(1);

        node.right.left = new TreeNode(1);
        node.right.right = new TreeNode(1);

        System.out.println(isUnivalTree(node));


    }
}
