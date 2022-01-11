package medium;

import DataStructure.TreeNode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/dong-hua-yan-shi-105-cong-qian-xu-yu-zhong-xu-bian/
 */
public class LeetCode105 {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; ++i) {
            if (preorder[0] == inorder[i]) {
                int[] preLeft = Arrays.copyOfRange(preorder, 1, i + 1);
                int[] preRight = Arrays.copyOfRange(preorder, i + 1, preorder.length);

                int[] inLeft = Arrays.copyOfRange(inorder, 0, i);
                int[] inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);

                root.left = buildTree(preLeft, inLeft);
                root.right = buildTree(preRight, inRight);
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] preOrder = new int[]{1, 2, 4, 5, 3, 6, 7};
        int[] middleOrder = new int[]{4, 2, 5, 1, 6, 3, 7};
        TreeNode node = buildTree(preOrder, middleOrder);
        TreeNode.travelTree(node);
    }
}
