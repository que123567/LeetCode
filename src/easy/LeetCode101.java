package easy;

import DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. Symmetric Tree
 * .
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * .
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * .
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */
public class LeetCode101 {
    /**
     * Recursion
     */
    class SolutionR {
        public boolean isSymmetric(TreeNode root) {
            return root == null || isSymmetricRe(root.left, root.right);

        }

        boolean isSymmetricRe(TreeNode left, TreeNode right) {
            if (left == null || right == null) {
                return left == right;
            }
            if (left.val != right.val) {
                return false;
            }
            return isSymmetricRe(left.left, right.right) && isSymmetricRe(left.right, right.left);
        }
    }

    /**
     * Iterarion
     */
    class SolutionI {
        public boolean isSymmetric(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            if (root == null)
                return true;
            queue.add(root.left);
            queue.add(root.right);
            while (queue.size() > 1) {
                TreeNode left = queue.poll(), right = queue.poll();
                if (left == null && right == null) {
                    continue;
                }
                if (left == null ^ right == null) {
                    return false;
                }
                if (left.val != right.val) {
                    return false;
                }
                queue.add(left.left);
                queue.add(right.right);

                queue.add(right.left);
                queue.add(left.right);
            }
            return true;
        }
    }


    public static void main(String[] args) {


    }
}
