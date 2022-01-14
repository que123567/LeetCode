package easy;

import DataStructure.TreeNode;


public class LeetCode111 {

    public static int minDepth(TreeNode root) {
        return minDepth(root, 0);
    }

    public static int minDepth(TreeNode root, int min) {
        if (root == null) {
            return min;
        }
        if (root.left == null) {
            return minDepth(root.right, min + 1);
        }
        if (root.right == null) {
            return minDepth(root.left, min + 1);
        }
        return Math.min(minDepth(root.left, min + 1), minDepth(root.right, min + 1));
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.right = new TreeNode(13);
        treeNode.right.left = new TreeNode(13);
        treeNode.right.right = new TreeNode(13);

        int a = minDepth(treeNode);
        System.out.println(a);

    }
}
