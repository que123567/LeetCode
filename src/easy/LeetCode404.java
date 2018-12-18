package easy;

import DataStructure.TreeNode;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 404. Sum of Left Leaves
 * <p>
 * Find the sum of all left leaves in a given binary tree.
 * <p>
 * Example:
 * <p>
 *       3
 *     /   \
 *    9     20
 *   /  \
 *  15   7
 * <p>
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class LeetCode404 {


    /**
     * recursion
     *
     * @param root
     * @return
     */
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        int ans = 0;
        if (root.left != null) {
            if (isLeave(root.left))
                ans += root.left.val;
            else
                ans += sumOfLeftLeaves(root.left);
        }
        ans += sumOfLeftLeaves(root.right);
        return ans;
    }

    public static int test(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.left != null) {
            if (isLeave(root.left)) {
                res += root.left.val;
            } else {
                res += test(root.left);
            }
        }
        res += test(root.right);
        return res;
    }


    /**
     * queue
     *
     * @param root
     * @return
     */

    public static int sumOfLeftLeaves_3(TreeNode root) {
        if (root == null || root.left == null && root.right == null)
            return 0;

        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr.left != null && curr.left.left == null && curr.left.right == null)
                res += curr.left.val;
            if (curr.left != null)
                queue.offer(curr.left);
            if (curr.right != null)
                queue.offer(curr.right);
        }
        return res;
    }

    /**
     * queue
     *
     * @param root
     * @return
     */
    public static int sumOfLeafLeaves_4(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();

            if (cur.left != null && cur.left.left == null & cur.left.right == null) {
                res += cur.left.val;
            }
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return res;
    }

    /**
     * queue
     *
     * @param root
     * @return
     */
    public static int sumOFLeafLeaves_5(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode.left != null && currentNode.left.left == null && currentNode.left.right == null) {
                res += currentNode.left.val;
            }
            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
        }
        return res;
    }

    /**
     * recursion
     *
     * @param root
     * @return
     */
    public static int sumOfLeafLeaves_6(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.left != null) {
            //is a leaf node
            if (root.left.left == null && root.left.right == null) {
                res += root.left.val;
            } else {
                //isn't a leaf node
                res += sumOfLeafLeaves_6(root.left);
            }
        }
        res += sumOfLeafLeaves_6(root.right);
        return res;
    }

    private static boolean isLeave(TreeNode treeNode) {
        return treeNode.left == null && treeNode.right == null;
    }


    public static void main(String[] args) {
        char a;
    }
}
