package easy;

import DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 112. Path Sum
 * <p>
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given the below binary tree and sum = 22,
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * <p>
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class LeetCode112 {
    /**
     * recursion
     *
     * @param root
     * @param sum
     * @return
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && sum - root.val == 0) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    /**
     * Iteration
     *
     * @param root
     * @param sum
     * @return
     */
    public static boolean hasPathSum_IT(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> pathQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        pathQueue.offer(root);
        sumQueue.offer(root.val);

        while (!pathQueue.isEmpty()) {
            TreeNode currentNode = pathQueue.poll();
            int currentVal = sumQueue.poll();

            if (currentNode.left == null && currentNode.right == null) {
                if (currentVal == sum) {
                    return true;
                }
            }
            if (currentNode.left != null) {
                pathQueue.offer(currentNode.left);
                sumQueue.offer(currentNode.left.val + currentVal);
            }
            if (currentNode.right != null) {
                pathQueue.offer(currentNode.right);
                sumQueue.offer(currentNode.right.val + currentVal);

            }
        }
        return false;
    }

}
