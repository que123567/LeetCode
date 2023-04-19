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

        //下面2个if的条件容易漏，如果是单叉树不加下面2个if判断直接返回depth为1（root）
        if (root.left == null) {
            return minDepth(root.right, min + 1);
        }
        if (root.right == null) {
            return minDepth(root.left, min + 1);
        }

        return Math.min(minDepth(root.left, min + 1), minDepth(root.right, min + 1));
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(2);
        treeNode1.right = new TreeNode(3);
        treeNode1.right.right = new TreeNode(4);
        treeNode1.right.right.right = new TreeNode(5);
        treeNode1.right.right.right.right = new TreeNode(6);

        int a = minDepth(treeNode1);
        System.out.println(a);
    }
}
