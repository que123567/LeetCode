import java.util.Stack;

/**
 * Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
 * <p>
 * <p>     3
 * /    \
 * 5      1
 * / \    / \
 * 6  2   9   8
 * / \
 * 7   4
 * <p>
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 * <p>
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 * <p>
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * Both of the given trees will have between 1 and 100 nodes.
 */
public class LeetCode872 {

    public static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return traverseString_(root1).equals(traverseString_(root2));
    }

    /**
     * 叶子节点从左往右遍历
     * recursion
     *
     * @param root
     * @return
     */
    public static String traverseString(TreeNode root) {
        if (root == null) {
            return "";
        }
        if (root.left == null && root.right == null) {
            return root.val + "-";
        }
        return traverseString(root.left) + traverseString(root.right);
    }

    /**
     * queue
     *
     * @param root
     * @return
     */
    public static String traverseString_(TreeNode root) {
        Stack<TreeNode> queue = new Stack<>();
        StringBuilder str = new StringBuilder();
        queue.push(root);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.pop();
            if (currentNode != null) {
                if (currentNode.left == null && currentNode.right == null) {
                    str.append(currentNode.val + "-");
                }
            }
            if (currentNode.right != null) {
                queue.push(currentNode.right);
            }
            if (currentNode.left != null) {
                queue.push(currentNode.left);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(1);

        treeNode.left.left = new TreeNode(6);
        treeNode.left.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(9);
        treeNode.right.right = new TreeNode(8);

        treeNode.left.left.left = new TreeNode(7);
        treeNode.left.left.right = new TreeNode(4);

        TreeNode treeNode2 = treeNode;
        System.out.println(leafSimilar(treeNode, treeNode2));

        System.out.println(traverseString_(treeNode));

    }
}
