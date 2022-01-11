package easy;


import DataStructure.TreeNode;

public class LeetCode543 {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
//        int leftMax = diameterOfBinaryTree(root.left);
//        int rightMax = diameterOfBinaryTree(root.right);
//        maxDiameter = Math.max(maxDiameter, leftMax + rightMax);
//
//        return 1 + Math.max(leftMax, rightMax);=
        return 0;
    }

  static   TreeNode searchBST(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        // 去左子树搜索
        if (root.val > target) {
            return searchBST(root.left, target);
        }
        // 去右子树搜索
        if (root.val < target) {
            return searchBST(root.right, target);
        }
        return root;
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        return false;
    }


    public static void main(String[] args) {
        TreeNode node = TreeNode.makeTree_Test_Case_3();
        TreeNode a = searchBST(node, 4);
        System.out.println(a.val);
    }
}
