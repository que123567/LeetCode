/**
 *
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class LeetCode100 {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }

    public static boolean isSametree(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val == right.val) {
            return isSameTree(left.left, right.left) && isSameTree(left.right, right.right);
        }
        return false;
    }

    public static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 1
     * / \
     * 2   3
     * /\   /\
     * 4 5  6 7
     *
     * @param args
     */
    public static void main(String[] args) {
        //treenode1
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);

        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        //treenode2
        TreeNode treeNode2 = new TreeNode(1);
        treeNode2.left = new TreeNode(2);
        treeNode2.right = new TreeNode(3);

        treeNode2.left.left = new TreeNode(4);
        treeNode2.left.right = new TreeNode(5);

        treeNode2.right.left = new TreeNode(6);
//        treeNode2.right.right = new TreeNode(7);

        System.out.println(isSameTree(treeNode, treeNode2));
        System.out.println(isSameTree(treeNode, treeNode));
        System.out.println(isSameTree(treeNode2, treeNode2));

    }
}