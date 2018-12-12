package middle;

/**
 * 814. Binary Tree Pruning
 * <p>
 * We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.
 * <p>
 * Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
 * <p>
 * (Recall that the subtree of a node X is X, plus every node that is a descendant of X.)
 */
//剪枝,去0
public class LeetCode814 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;
    }

    public static TreeNode pruneTree_(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree_(root.left);
        root.right = pruneTree_(root.right);
        if (canRemoved(root.left)) {
            root.left = null;

        }
        if (canRemoved(root.right)) {
            root.right = null;
        }
        return root;
    }

    public static boolean canRemoved(TreeNode root) {
        return root != null && root.val == 0 && root.left == null && root.right == null;
    }


    /**
     * 1
     * /   \
     * 2     2
     * / \   / \
     * 0   0 0  0
     */
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(0);

        TreeNode node = pruneTree_(root);
        int i = 1;

    }
}
